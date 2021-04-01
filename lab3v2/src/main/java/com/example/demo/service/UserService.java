package com.example.demo.service;

import com.example.demo.persistence.dao.daoimpl.ConferenceImpl;
import com.example.demo.persistence.dao.daoimpl.UserImpl;
import com.example.demo.persistence.dao.entities.Conference;
import com.example.demo.persistence.dao.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserImpl userDao;
    private final ConferenceImpl conferenceDao;


    public List<User> getAll() {
        return userDao.findAll();
    }
    public List<User> getByName() {
        return userDao.findByUserName("newUser");
    }

    @Transactional
    public User newUser(User user) {
        Conference conf1 = new Conference();
        conf1.setTitle("new");
        conferenceDao.add(conf1);

        Conference conf2 = new Conference();
        conf1.setTitle("new2");
        conferenceDao.add(conf2);

        Conference conf3 = new Conference();
        conf1.setTitle("new3");
        conferenceDao.add(conf3);

        user.setConferences(Arrays.asList(conf1, conf2, conf3));
        return userDao.add(user);
    }
}
