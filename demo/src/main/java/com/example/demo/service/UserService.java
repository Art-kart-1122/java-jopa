package com.example.demo.service;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.UsersDao;
import com.example.demo.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public class UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<UsersEntity> findAllUsers() {
        UsersDao userDao = daoFactory.createUsersDao();
        return userDao.findAll();
    }


    public Optional<UsersEntity> findByUsername(String username) {
        try (UsersDao userDao = daoFactory.createUsersDao()) {

            Optional<UsersEntity> userOptional = userDao.findByUsername(username);
            return userOptional;
        }
    }

    public void saveUser(UsersEntity user) {
        try (UsersDao userDao = daoFactory.createUsersDao()) {
            userDao.create(user);
        }

    }

}
