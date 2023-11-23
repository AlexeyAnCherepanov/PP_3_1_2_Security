package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{
    private final EntityManager em;

    @Autowired
    public RoleDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Set<Role> getRolesById(int id) {
        return Collections.singleton(em.find(Role.class, id));
    }
    @Override
    @Transactional
    public List<Role> getRoles() {
        List<Role> roles = em.createQuery("from Role").getResultList();
        if (roles.size()==0) {
            Role role = new Role("ROLE_ADMIN");
            Role role1 = new Role("ROLE_USER");
            roles.add(role);
            roles.add(role1);
            em.persist(role);
            em.persist(role1);
            em.flush();
        }
        return roles;
    }
}
