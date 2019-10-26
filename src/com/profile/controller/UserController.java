package com.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.profile.model.Login;

@Controller
public class UserController {

  @RequestMapping(value= "/users",method = RequestMethod.GET)
  public ModelAndView getLoginForm (){
    ModelAndView mav = new ModelAndView("userList");
//    System.out.println("map size in lognform controller " + UserRegistrationController.userMap.size());
    mav.addObject("userListBean", UserRegistrationController.userMap);
    return mav;
  }
  
  @RequestMapping(value= "/users/{userId}/", method = RequestMethod.GET)
  public ModelAndView displayUserDetais(@PathVariable(name = "userId") String  key) {
    
    System.out.println("in users usersid detail");

    Login login = UserRegistrationController.userMap.get(key);
    ModelAndView mav = new ModelAndView("details");
    mav.addObject("userBean", login);
    return mav;
     
  }
  @RequestMapping(value= "/editUserCredential/{userId}/", method = RequestMethod.GET)
  public ModelAndView editUserCredential (@PathVariable(name = "userId") String  key){
    Login login = UserRegistrationController.userMap.get(key);
    System.out.println("in users edit credential");
    System.out.println("login " + login.toString());
    
    ModelAndView mav = new ModelAndView("userCredentialForm");
    mav.addObject("userCredentialFormObj", login);
    mav.addObject("action","update");
    return mav;
  }

  
}
