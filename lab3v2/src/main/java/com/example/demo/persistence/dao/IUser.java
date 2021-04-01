package com.example.demo.persistence.dao;

import com.example.demo.persistence.dao.entities.User;

import java.util.List;

public interface IUser extends IBase<User> {
    List<User> findByUserName(String userName);
    User findByIdWithConferences(Long Id);
}