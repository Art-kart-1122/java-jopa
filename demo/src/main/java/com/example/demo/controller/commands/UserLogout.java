package com.example.demo.controller.commands;

import com.example.demo.controller.Webpage;

import javax.servlet.http.HttpServletRequest;

public class UserLogout implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/redirect:" + Webpage.INDEX_PAGE;
    }
}
