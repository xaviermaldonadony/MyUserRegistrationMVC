package com.profile.controller;

import java.util.*;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.profile.model.Login;

@Controller
public class LoginController {

	public static Map<String, Login> loginList;

	public LoginController() {
		// TODO Auto-generated constructor stub
		loginList = new HashMap<String, Login>();
//		loginList.put("max", new Login("max", "max@aol.com","123456", new Date()));
//		loginList.put("lucy", new Login("lucy", "lucy@aol.com","123456",new Date()));
		
  loginList.put("max", new Login("max", "max@aol.com","123456"));
  loginList.put("lucy", new Login("lucy", "lucy@aol.com","123456"));
		
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
//		if (binding.hasErrors()) {
//			ModelAndView mv = new ModelAndView("violation");
//			mv.addObject("message", "There were data violation");
//			return mv;
//		}
	  
//	  loginList.forEach((k,v) -> System.out.println("Key = "
//        + k + ", Value = " + v));
		ModelAndView mav = null;

		if (!binding.hasErrors() || binding.getRawFieldValue("name") == null) {
			String usernameForm = login.getEmail();
			String passwordForm = login.getPassword();
			Login exists = UserRegistrationController.userMap.get(usernameForm);
			
			if (exists != null && passwordForm.equals(exists.getPassword())) {
				mav = new ModelAndView("welcome");
				mav.addObject("name", login.getName());
			} else {
				mav = new ModelAndView("loginForm");
				mav.addObject("message", "Username or Password is wrong!");
			}
			return mav;
		} else {

			mav = new ModelAndView("loginForm");
			mav.addObject("message", "Constraint Violation!");
			return mav;
		}

	}
	public static Map<String, Login> getLoginList() {
	  return loginList;
	}
}
