package com.profile.controller;

import com.profile.model.Login;
import com.profile.service.loginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    Map<String, Login> loginList;

    public Map<String, Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(Map<String, Login> loginList) {
        this.loginList = loginList;
    }

    public LoginController() {
        loginList = new HashMap<>();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView mav = new ModelAndView("loginForm");
        // refers to the model attribute within the loginForm.jsp
        mav.addObject("loginForm", new Login());
        return mav;
    }

    // loginProcess refers to the action within the form
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@Valid @ModelAttribute("loginForm") Login login, BindingResult binding) {

        System.out.println("From parameter login -> " + login.toString());
        ModelAndView mav = null;
        if (!binding.hasErrors() || binding.getRawFieldValue("name") == null) {
            System.out.println(login.toString());
            String emailForm = login.getEmail();
            String passwordForm = login.getPassword();
            Login exists = loginService.getLoginByEmail(emailForm);
            if (exists != null && passwordForm.equals(exists.getPassword())) {
                mav = new ModelAndView("welcome");
                mav.addObject("name", exists.getName());
            } else {
                mav = new ModelAndView("loginForm");
                mav.addObject("message", "Username or Password is wrong!");
            }
            return mav;
        } else {
            binding.getAllErrors().forEach(System.out::println);
            System.out.println(login.toString());
            mav = new ModelAndView("loginForm");
            mav.addObject("message", "Constraint Violation!");
            return mav;
        }
    }
}