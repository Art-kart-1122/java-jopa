package com.example.demo.dao;

import com.example.demo.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface UsersDao extends GenericDao<UsersEntity> {
    List<UsersEntity> findByName(String firstName, String lastName);
    List<UsersEntity> findByName(String userName);
    Optional<UsersEntity> findByUsername(String username);
}
