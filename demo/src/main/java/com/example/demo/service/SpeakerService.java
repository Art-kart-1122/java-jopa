package com.example.demo.service;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.SpeakersDao;
import com.example.demo.entity.SpeakersEntity;


import java.util.List;


public class SpeakerService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<SpeakersEntity> findAllSpeakers() {
        SpeakersDao speakerDao = daoFactory.createSpeakersDao();
        return speakerDao.findAll();
    }

}
