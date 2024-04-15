package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("FrOm User", User.class);
        return query.getResultList();
    }

    public boolean add(User user) {
        entityManager.persist(user);
        return true;
    }

    public User findByEmail(String email) {
        return entityManager.createQuery("select xxx FROM User xxx JOIn fETCH xxx.roles WHERe xxx.email = :id", User.class)
                .setParameter("id", email)
                .getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void removeUser(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}

