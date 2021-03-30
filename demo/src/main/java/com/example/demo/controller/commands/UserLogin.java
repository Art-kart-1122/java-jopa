package com.example.demo.controller.commands;

import com.example.demo.controller.Webpage;
import com.example.demo.entity.UsersEntity;
import com.example.demo.manager.SecretManager;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class UserLogin implements Command {
    private static final String CONTROLLER_PAGE = "login.jsp";
    private final UserService userService;

    public UserLogin(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        String[] validationFields = {"login_email", "login_password"};
        boolean isValid = Arrays.stream(validationFields)
                .map(request::getParameter)
                .allMatch(this::validateField);

        if (!isValid)
            return CONTROLLER_PAGE;

        String email = request.getParameter("login_email");
        String password = request.getParameter("login_password");

        Optional<UsersEntity> userOptional = userService.findByUsername(email);

        if (!userOptional.isPresent()) {
            request.setAttribute("errorLoginPassMessage", "Wrong credentials");
            return CONTROLLER_PAGE;
        }

        UsersEntity loginUser = userOptional.get();
        if (loginUser.getPassword().equals(convertPasswordToHash(password))) {
            request.getSession().setAttribute("user", loginUser);
            returnWithMessage("indexMessage", "Welcome back!", request);
            return Webpage.INDEX_PAGE;
        }

        request.setAttribute("errorLoginPassMessage", "Wrong credentials");
        return CONTROLLER_PAGE;
    }


    private boolean validateField(String value) {
        if (value == null) return false;
        else if ("".equals(value)) return false;
        return true;
    }

    private String convertPasswordToHash(String rawPassword) {
        String textToHash = SecretManager.getProperty("hash.salt.start") +
                rawPassword +
                SecretManager.getProperty("hash.salt.end");

        return SecretManager.getBytesToHex(SecretManager.encodeToSHA256(textToHash));
    }

    private String returnWithMessage(String attributeMessageName, String attributeMessageValue, HttpServletRequest request) {
        request.setAttribute(attributeMessageName, attributeMessageValue);
        return CONTROLLER_PAGE;
    }

}

