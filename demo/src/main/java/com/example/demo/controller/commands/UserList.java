package com.example.demo.controller.commands;

import com.example.demo.entity.UsersEntity;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserList implements Command {
    private static final String CONTROLLER_PAGE = "user_list.jsp";
    private final UserService userService;

    public UserList(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<UsersEntity>  users = this.userService.findAllUsers();
        System.out.println(users.get(0).getFirstName());
        request.setAttribute("users", users);
        return CONTROLLER_PAGE;
    }
}
