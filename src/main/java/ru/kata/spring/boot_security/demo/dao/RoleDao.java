package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDao {

    boolean add(Role role);

    Role findByName(String name);

    List<Role> listByName(List<String> name);
}
