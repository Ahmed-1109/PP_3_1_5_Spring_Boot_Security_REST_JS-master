package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getById(Integer id);

    List<User> listUsers();

    void removeUser(Integer id);

    void updateUser(User user);

    boolean add(User user);


    User findByEmail(String email);

}