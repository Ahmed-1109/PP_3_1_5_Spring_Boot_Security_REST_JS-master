package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

   /* @Autowired
    RoleDao roleDao;

    @Autowired
    RoleDao gg;
*/
    public boolean add(Role role) {
        entityManager.persist(role);
        //Salam

        return true;
    }

    public Role findByName(String name) {
        return entityManager.createQuery("select xxx FROM Role xxx WHERe xxx.role = :id", Role.class)
                .setParameter("id", name)
                .getResultList().stream().findAny().orElse(null);
    }

    public List<Role> listByName(List<String> name) {
        return entityManager.createQuery("select xxx FROM Role xxx WHERe xxx.role in (:id)", Role.class)
                .setParameter("id", name)
                .getResultList();
    }
}
