package com.profile.repository;

import com.profile.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {

    Login findByEmail(String email);

    //TODO: Find users by between dates --> List<Login>
//    List<Login> findByDateOfBirthBetween
    List<Login> findByDateOfBirth(Date dob);
}
