package ru.kata.spring.boot_security.demo.userinit;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer {

    private final UserServiceImpl userService;

    private final RoleService roleService;

    public Initializer(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");


        roleService.addRole(role1);
        roleService.addRole(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();

        roleAdmin.add(role1);
        roleAdmin.add(role2);

        roleUser.add(role2);


        User user1 = new User("user", "user", 55, "user@user.ru","user", roleUser);
        User admin1 = new User("admin", "admin", 99, "admin@admin.ru","admin", roleAdmin);

        userService.add(admin1);
        userService.add(user1);

    }
}
