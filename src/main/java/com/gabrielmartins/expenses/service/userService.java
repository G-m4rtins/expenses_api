package com.gabrielmartins.expenses.service;

import com.gabrielmartins.expenses.entity.User;
import com.gabrielmartins.expenses.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;


    //Criação de um novo usuario
    public User createUser(User user){
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userRepository.save(user);
    }

    //Retorna um usuario pelo id usando Optional para evitar exceções
    public Optional<User> getUserById(Long id){
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return userRepository.findById(id);
    }

    //Retorna um usuario pelo email e senha
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Email and password cannot be null or empty");
        }
        return Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
    }

    //Retorna um usuario pelo email
    public Optional<User> getUserByEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    //Retorna um usuario pelo nome
    public Optional<User> getUserByName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return Optional.ofNullable(userRepository.findByName(name));
    }

    // Retorna todos os usuarios
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Retorna todos os usuários pela data de registro
    public List<User> findByRegistrationDate(LocalDate registrationDate) {
        if (registrationDate == null) {
            throw new IllegalArgumentException("Registration date cannot be null");
        }
        return userRepository.findByRegistrationDate(registrationDate);
    }

    public void deleteUser(Long id){
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null for update");
        }
        if (!userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User not found with ID: " + user.getId());
        }
        return userRepository.save(user);
    }
}

