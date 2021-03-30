package com.example.demo;

import com.example.demo.controller.Webpage;
import com.example.demo.controller.commands.Command;
import com.example.demo.controller.commands.*;
import com.example.demo.service.ConferenceService;
import com.example.demo.service.SpeakerService;
import com.example.demo.service.UserService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Servlet extends HttpServlet {
    private UserService userService = new UserService();
    private ConferenceService conferenceService = new ConferenceService();
    private SpeakerService speakerService = new SpeakerService();


    private Map<String, Command> commands = new HashMap<>();

    public void init() {
        commands.put(Webpage.LOGIN_PAGE, new UserLogin(userService));
        commands.put(Webpage.REGISTER_PAGE, new UserRegister(userService));
        commands.put(Webpage.USER_LIST, new UserList(userService));
        commands.put(Webpage.LOGOUT, new UserLogout());
        commands.put(Webpage.CONFERENCE, new ConferenceList(conferenceService));
        commands.put(Webpage.CONFERENCE_CREATE, new ConferenceCreate(conferenceService, speakerService));
        commands.put(Webpage.CONFERENCE_DELETE, new ConferenceDelete(conferenceService));
        System.out.println("SERVLET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getRequestURI();


        if (path.contains("redirect:")) {
            response.sendRedirect(path.replaceAll("/redirect:", ""));
            return;
        }

        System.out.println("PATH  " + path);
        Command command = commands.getOrDefault(path , (r)->"/index.jsp");
        String page = command.execute(request);

        if (page.contains("redirect:")) {
            response.sendRedirect(page.replaceAll("/redirect:", ""));
            return;
        }
        else
            request.getRequestDispatcher(page).forward(request, response);
    }
}