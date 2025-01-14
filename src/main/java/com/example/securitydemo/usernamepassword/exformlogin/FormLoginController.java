package com.example.securitydemo.usernamepassword.exformlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormLoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }
}
