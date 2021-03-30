package com.example.demo.service;

import com.example.demo.dao.ConferencesDao;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.UsersDao;
import com.example.demo.entity.ConferencesEntity;
import com.example.demo.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public class ConferenceService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<ConferencesEntity> findAllConferences() {
        ConferencesDao conferencesDao = daoFactory.createConferencesDao();
        return conferencesDao.findAll();
    }


    public ConferencesEntity findBy(Long id) {
        try (ConferencesDao conferenceDao = daoFactory.createConferencesDao()) {
            ConferencesEntity conference = conferenceDao.findById(id);
            return conference;
        }
    }

    public void delete(ConferencesEntity conference) {
        try (ConferencesDao conferenceDao = daoFactory.createConferencesDao()) {
            conferenceDao.delete(conference);
        }
    }

    public void saveConferences(ConferencesEntity conference) {
        try (ConferencesDao conferenceDao = daoFactory.createConferencesDao()) {
            conferenceDao.create(conference);
        }

    }
}
