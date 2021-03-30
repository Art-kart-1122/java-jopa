package com.example.demo.controller.commands;

import com.example.demo.controller.Webpage;
import com.example.demo.entity.ConferencesEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;

public class ConferenceDelete implements Command {
    private final ConferenceService conferenceService;

    public ConferenceDelete(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }
    @Override
    public String execute(HttpServletRequest request) {

        String conferenceIdString = request.getQueryString().split("=")[1];

        if (conferenceIdString == null)
            return Webpage.CONFERENCE;

        Long conferenceId = Long.parseLong(conferenceIdString);
        ConferencesEntity conference = conferenceService.findBy(conferenceId);

        if(conference.getModeratorId().equals(((UsersEntity) request.getSession().getAttribute("user")).getId()))
            conferenceService.delete(conference);
        else
            request.setAttribute("errorConferenceMessage","Permission denied");

        return Webpage.CONFERENCE;
    }
}
