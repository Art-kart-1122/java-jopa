package com.example.demo.persistence.dao.daoimpl;

import com.example.demo.persistence.dao.IConference;
import com.example.demo.persistence.dao.entities.Conference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConferenceImpl implements IConference {

    @PersistenceContext
    private EntityManager em;

    public Conference add(Conference entity) {
        em.persist(entity);
        return em.find(Conference.class, entity.getId());
    }

    public Conference update(Conference entity) {
        em.persist(entity);
        return em.find(Conference.class, entity.getId());
    }

    public void delete(Conference entity) {
        em.remove(entity);
    }

    public List<Conference> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Conference> cq = cb.createQuery(Conference.class);
        Root<Conference> conference = cq.from(Conference.class);
        cq.select(conference);
        return em.createQuery(cq).getResultList();
    }

    public Optional<Conference> findById(Long id) {
        return Optional.of(em.find(Conference.class, id));
    }

    public Conference findByTitle(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Conference> query = cb.createQuery(Conference.class);
        Root<Conference> user = query.from(Conference.class);

        Predicate filter = cb.equal(user.get("title"), title);
        query.where(filter);
        return em.createQuery(query).getSingleResult();
    }
}