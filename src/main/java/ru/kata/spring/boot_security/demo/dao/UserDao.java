package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {

    User getById(Integer id);

    List<User> listUsers();

    boolean add(User user);

    void removeUser(Integer id);

    void updateUser(User user);

    User findByEmail(String email);
}
