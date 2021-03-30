package com.example.demo.controller.commands;

import com.example.demo.entity.ConferencesEntity;
import com.example.demo.service.ConferenceService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ConferenceList  implements Command {
    private static final String CONTROLLER_PAGE = "conferences_list.jsp";
    private final ConferenceService conferenceService;

    public ConferenceList(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<ConferencesEntity> conferences = this.conferenceService.findAllConferences();
        request.setAttribute("conferences", conferences);
        return CONTROLLER_PAGE;
    }
}
