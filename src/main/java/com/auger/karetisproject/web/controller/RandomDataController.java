package com.auger.karetisproject.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomDataController {

    @RequestMapping("/user")
    public String showUserMsg()
    {
        return "User has logged in!!!";

    }

}
