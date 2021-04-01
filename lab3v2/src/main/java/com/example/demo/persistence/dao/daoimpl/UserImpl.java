package com.example.demo.persistence.dao.daoimpl;

import com.example.demo.persistence.dao.IUser;
import com.example.demo.persistence.dao.entities.Conference;
import com.example.demo.persistence.dao.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserImpl implements IUser {

    @PersistenceContext
    private EntityManager em;

    public User add(User entity) {
        em.persist(entity);
        return em.find(User.class, entity.getId());
    }

    public User update(User entity) {
        em.persist(entity);
        return em.find(User.class, entity.getId());
    }

    public void delete(User entity) {
        em.remove(entity);
    }

    public List<User> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.select(user);
        return em.createQuery(cq).getResultList();
    }

    public Optional<User> findById(Long id) {
        return Optional.of(em.find(User.class, id));
    }

    public List<User> findByUserName(String userName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        Predicate filter = cb.equal(user.get("userName"), userName);
        query.where(filter);
        return em.createQuery(query).getResultList();
    }

    public User findByIdWithConferences(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        user.join("Conference");

        Predicate filterId = cb.equal(user.get("id"), id);
        query.where(filterId);
        return em.createQuery(query).getSingleResult();
    }
}