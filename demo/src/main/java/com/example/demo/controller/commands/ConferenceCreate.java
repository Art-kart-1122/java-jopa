package com.example.demo.controller.commands;

import com.example.demo.controller.Webpage;
import com.example.demo.entity.ConferencesEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.service.ConferenceService;
import com.example.demo.service.SpeakerService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class ConferenceCreate implements Command {
    private final ConferenceService conferenceService;
    private final SpeakerService speakerService;

    private static final String CONTROLLER_PAGE = "conference_create.jsp";

    public ConferenceCreate(ConferenceService conferenceService, SpeakerService speakerService) {
        this.conferenceService = conferenceService;
        this.speakerService = speakerService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String[] validationFields = {
                "conference_title",
                "conference_date",
                "conference_place",
                "conference_speaker"
                };

        boolean passValue = Arrays.stream(validationFields)
                .map(request::getParameter)
                .allMatch(this::validateField);

        request.setAttribute("speakers", speakerService.findAllSpeakers());

        if (!passValue) {
            request.setAttribute("errorConferenceMessage", "Wrong credentials");
            return CONTROLLER_PAGE;
        }


        ConferencesEntity conference = new ConferencesEntity();

        conference.setTitle(request.getParameter("conference_title"));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("conference_date"), formatter);

        conference.setDate(dateTime);

        conference.setPlace(request.getParameter("conference_place"));
        conference.setQuantityExpectedVisitors(request.getParameter("conference_visitors"));
        conference.setQuantityVisited(0);
        conference.setModeratorId(((UsersEntity) request.getSession().getAttribute("user")).getId());
        conference.setSpeakerId(Long.parseLong(request.getParameter("conference_speaker")));


        try {
            conferenceService.saveConferences(conference);
        }catch (RuntimeException ex) {
            request.setAttribute("conference_error", ex.getMessage());
        }

        return Webpage.CONFERENCE;
    }

    private boolean validateField(String value) {
        if(value == null) return false;
        else if (value.equals("")) return false;
        else return true;
    }

}
