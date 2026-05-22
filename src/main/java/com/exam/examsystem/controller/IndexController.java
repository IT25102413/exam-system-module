package com.exam.examsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showPortal() {
        return "index"; // This points straight to templates/index.html
    }
}