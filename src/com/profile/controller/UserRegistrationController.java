package com.profile.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.profile.model.Login;


@Controller
public class UserRegistrationController {
  
  public static Map<String, Login> userMap;
  
  public UserRegistrationController() {
    userMap = new HashMap<String, Login>();
  }
  @RequestMapping(value ="/register", method = RequestMethod.GET)
  public ModelAndView getUserCredential(){
  
    ModelAndView mav = new ModelAndView("userCredentialForm");
    mav.addObject("userCredentialFormObj", new Login());
    return mav;
  }
  
  
  @RequestMapping(value = "saveUserCredential", method = RequestMethod.POST)
  public ModelAndView saveUserCredential(@Valid @ModelAttribute("userCredentialFormObj") Login login, BindingResult br, @RequestParam("email") String email, @RequestParam("confPassword") String confPassword, RedirectAttributes redirect) {

    ModelAndView mav = null;
    Login credential = new Login();

    System.out.println("in sveUserCredential method");
    if(br.hasErrors()) {
      System.out.println("error in user reg cont " +
    login.toString());
      mav = new ModelAndView("userCredentialForm");
      
    }
    
    else {
      if(login.getPassword().equals(confPassword)) {
        
//        credential = new Login(login.getName(), login.getEmail(), login.getPassword(), new Date());
        credential = new Login(login.getName(), login.getEmail(), login.getPassword());

        userMap.put(credential.getEmail(), credential);

        System.out.println("login credential " + login.toString());
        mav = new ModelAndView("registrationConfirmation");
        mav.addObject("message", "credential succesuflly created");
  
      }else {
        mav = new ModelAndView("userCredentialForm");
        mav.addObject("message", "credential error paswords are not matching");
        
      }
    }
    return mav;

  }
}
