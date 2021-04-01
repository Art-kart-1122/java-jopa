package com.example.demo.persistence.dao;

import com.example.demo.persistence.dao.entities.Conference;

public interface IConference extends IBase<Conference> {
    Conference findByTitle(String title);
}
