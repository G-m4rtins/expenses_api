package com.gabrielmartins.expenses.service;

import com.gabrielmartins.expenses.entity.User;
import com.gabrielmartins.expenses.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;


    //Criaçao de um novo usuario
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Retorna um usuario pelo id
    public User getUserById(Long id){
        return userRepository.getOne(id);
    }

    //Retorna um usuario pelo email e senha
    public User getUserByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }

    //Retorna um usuario pelo email
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    //Retorna um usuario pelo nome
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    // Retorna todos os usuarios
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Retorna todos os usuários pela data de registro
    public List<User> findByRegistrationDate(LocalDate registrationDate) {
        return userRepository.findByRegistrationDate(registrationDate);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }
}

