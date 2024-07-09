package com.bookity.project.candidate.arda.onur.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appViewController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
}
