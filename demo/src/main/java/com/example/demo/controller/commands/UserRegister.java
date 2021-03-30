package com.example.demo.controller.commands;

import com.example.demo.controller.Webpage;
import com.example.demo.entity.UsersEntity;
import com.example.demo.manager.SecretManager;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class UserRegister implements Command {
    private final UserService userService;
    private static final String CONTROLLER_PAGE = "register.jsp";

    public UserRegister(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String[] validationFields = {"register_first_name",
                "register_last_name",
                "register_email",
                "register_password"};

        boolean passValue = Arrays.stream(validationFields)
                .map(request::getParameter)
                .allMatch(this::validateField);

        if (!passValue) {
            request.setAttribute("errorRegisterMessage", "Wrong credentials");
            return CONTROLLER_PAGE;
        }


        Optional<UsersEntity> userOptional = userService.findByUsername(request.getParameter("register_email"));

        if (userOptional.isPresent()) {
            request.setAttribute("errorRegisterMessage", "User with username exist");
            return CONTROLLER_PAGE;
        }

        UsersEntity registeredUser = new UsersEntity();

        registeredUser.setFirstName(request.getParameter("register_first_name"));
        registeredUser.setLastName(request.getParameter("register_last_name"));
        registeredUser.setUserName(request.getParameter("register_email"));
        registeredUser.setPassword(convertPasswordToHash(request.getParameter("register_password")));


        try {
            userService.saveUser(registeredUser);
        }catch (RuntimeException ex) {
            request.setAttribute("registration_error", ex.getMessage());
        }

        return Webpage.LOGIN_PAGE;
    }


    private String convertPasswordToHash(String rawPassword) {
        String textToHash = SecretManager.getProperty("hash.salt.start") +
                rawPassword +
                SecretManager.getProperty("hash.salt.end");
        System.out.println(textToHash);
        return SecretManager.getBytesToHex(SecretManager.encodeToSHA256(textToHash));
    }

    private boolean validateField(String value) {
        if(value == null) return false;
        else if (value.equals("")) return false;
        else return true;
    }
}
