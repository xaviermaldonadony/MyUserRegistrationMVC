//package com.profile.service.loginService;
//
//
//import java.util.Date;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.profile.model.Login;
//import com.profile.repository.LoginRepository;
//
//@Transactional
//@Service
//public class LoginService {
//  
//  @Autowired 
//  LoginRepository loginRepository;
//  
//  public Login getLoginByEmail(String email) {
//    
//    return loginRepository.findByEmail(email);
//  }
//  
//  List<Login> getAllByDateOfBirth(Date date){
//   return loginRepository.findLoginBydateOfBirth(date);
//  }
//  
//  public boolean addLogin(Login login) {
//    return loginRepository.save(login) != null;
//  }
//  
//  public boolean updateLogin(Login login) {
//    return loginRepository.save(login) != null;
//  }
//  public void deleteLogin(Login login) {
//    loginRepository.delete(login);
//    loginRepository.deleteById(login.getId());
//  }
//  
//  
//}
