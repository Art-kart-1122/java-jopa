package com.example.demo.dao;

import com.example.demo.entity.ConferencesEntity;



public interface ConferencesDao extends GenericDao<ConferencesEntity> {
    ConferencesEntity findById(Long id);
}
