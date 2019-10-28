package com.profile.controller;

import com.profile.model.Login;
import com.profile.service.loginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class UserRegistrationController {

    @Autowired
    LoginService loginService;

    public static Map<String, Login> userMap;

    public UserRegistrationController() {
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(sdf, false));
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getUserCredentialForm() {
        ModelAndView mav = new ModelAndView("userCredentialForm");
        mav.addObject("userCredentialFormObj", new Login());
        return mav;
    }

    @RequestMapping(value = "processUserCredential", method = RequestMethod.POST)
    public ModelAndView processUserCredential(@Valid @ModelAttribute("userCredentialFormObj") Login login,
                                              BindingResult br,
                                              @RequestParam("confirmPassword") String confPassword,
                                              RedirectAttributes redirect) {
        //@RequestParam("confirmPassword") String confPassword is pulled from the user submission
        // to confirm that their passwords match, this is coming from the HTML/JSP page, not Java code
        ModelAndView mav = null;
        Login credential = loginService.getLoginByEmail(login.getEmail());

        if (br.hasErrors()) {
            br.getAllErrors().forEach(System.out::println);
            mav = new ModelAndView("userCredentialForm");
        } else {
            if (credential == null) { //registration
                if (login.getPassword().equals(confPassword)) {
                    credential = new Login(login.getName(), login.getEmail(), login.getPassword(), new Date());
                    loginService.addLogin(credential);
                    mav = new ModelAndView("registrationConfirmation");
                    mav.addObject("userCredential", loginService.getLoginByEmail(credential.getEmail()));
                    mav.addObject("message", "Credential successfully created");
                    System.out.println(credential.toString());
                }

            } else { //updating
                if (login.getPassword().equals(confPassword)) { //check if password & confirmPassword match
                    credential.setName(login.getName()); //set the name for the credential
                    credential.setPassword(login.getPassword()); //set the password for the credential
                    loginService.updateLogin(credential); //update the login rather than add it back and as a result incrementing its id
                    redirect.addFlashAttribute("message", "credentials successfully updated"); //msg to be sent
                    mav = new ModelAndView("redirect:/users"); //redirect back to the user list
                }
            }
        }
        return mav;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUserForm() {
        ModelAndView mav = new ModelAndView("userList");
        mav.addObject("userListBean", loginService.getAllLogin());
        return mav;
    }

    @RequestMapping(value = "/users/{userEmail}/", method = RequestMethod.GET)
    public ModelAndView getUserDetails(@PathVariable String userEmail) {
        ModelAndView mav = new ModelAndView("userDetails");
        System.out.println("end my suffering");
        mav.addObject("userDetail", loginService.getLoginByEmail(userEmail));
        return mav;
    }

    @RequestMapping(value = "/edit/{userEmail}/", method = RequestMethod.GET)
    public ModelAndView editUserCredentials(@PathVariable String userEmail) {
        ModelAndView mav = new ModelAndView("userCredentialForm");
        Login credentialsToUpdate = loginService.getLoginByEmail(userEmail);
        mav.addObject("userCredentialFormObj", credentialsToUpdate);
        mav.addObject("action", "update");
        return mav;
    }


    @RequestMapping(value = "/delete/{userEmail}/", method = RequestMethod.GET)
    public ModelAndView getUserFormAfterDelete(@PathVariable String userEmail, RedirectAttributes redirect) {
        loginService.deleteLogin(loginService.getLoginByEmail(userEmail));
        redirect.addFlashAttribute("message", "user successfully deleted");
        return new ModelAndView("redirect:/users");
    }
}