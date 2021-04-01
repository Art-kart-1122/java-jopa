package com.example.demo.presentation;

import com.example.demo.persistence.dao.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;



    @GetMapping(path="/add")
    public @ResponseBody User addNewUser () {
        User user = new User();
        user.setUserName("newUser");
        return userService.newUser(user);
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path="/name")
    public @ResponseBody
    List<User> getName() {
        return userService.getByName();
    }
}

