package com.apap.siperpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index () {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
