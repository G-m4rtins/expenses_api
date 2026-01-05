package com.gabrielmartins.expenses.repository;

import com.gabrielmartins.expenses.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface userRepository extends org.springframework.data.jpa.repository.JpaRepository<com.gabrielmartins.expenses.entity.User, Long> {

    List<User> findAll();
    User findByEmail(String email);
    User findByName(String name);
    List<User> findByRegistrationDate(LocalDate registrationDate);
    User findByEmailAndPassword(String email, String password);
}
