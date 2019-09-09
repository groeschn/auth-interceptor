package de.groeschn.javaee.dao;

import de.groeschn.javaee.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {

    @Inject
    EntityManager em;

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public User findUserByUsername(String username) {
        List results = em.createNamedQuery("User.findByUsername").setParameter("username", username).getResultList();
        if (!results.isEmpty()) {
            return (User) results.get(0);
        } else {
            return null;
        }
    }
}
