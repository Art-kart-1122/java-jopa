package com.example.demo.dao;

import com.example.demo.entity.SpeakersEntity;

public interface SpeakersDao extends GenericDao<SpeakersEntity> {
    SpeakersEntity findById(Long id);
}
