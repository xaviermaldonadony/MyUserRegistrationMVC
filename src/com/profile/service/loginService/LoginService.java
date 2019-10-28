package com.profile.service.loginService;

import com.profile.model.Login;
import com.profile.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public List<Login> getAllLogin() {
        List<Login> loginList = new ArrayList<>();
        loginRepository.findAll().forEach(loginList::add);
        return loginList;
    }

    public Login getLoginByEmail(String email) {
        return loginRepository.findByEmail(email);
    }


    public boolean addLogin(Login login) {
        return loginRepository.save(login) != null;
    }

    @Transactional
    public boolean updateLogin(Login login) {
        return loginRepository.save(login) != null;
    }

    public void deleteLogin(Login login) {
        loginRepository.delete(login);
        loginRepository.deleteById(login.getId());
    }

}
