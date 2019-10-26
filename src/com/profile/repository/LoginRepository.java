package com.profile.repository;
import com.profile.model.Login;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {

  Login findByEmail(String email);
  List<Login> findLoginBydateOfBirth(Date dateOfBirth);
}
