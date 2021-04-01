package com.example.demo.service;

import com.example.demo.persistence.dao.daoimpl.ConferenceImpl;
import com.example.demo.persistence.dao.daoimpl.UserImpl;
import com.example.demo.persistence.dao.entities.Conference;
import com.example.demo.persistence.dao.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConferenceService {
    private final ConferenceImpl conferenceDao;


    public List<Conference> getAll() {
        return conferenceDao.findAll();
    }

    public Conference newConference(Conference conference) {
        return conferenceDao.add(conference);
    }
}
