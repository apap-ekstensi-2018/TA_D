package com.apap.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Primary
public class MainController {

    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }

    @RequestMapping("/literatur/tambah")
    public String tambahliteratur ()
    {
        return "Literatur/tambahliteratur";
    }

    @RequestMapping("/literatur/ubah/")
    public String ubahLiteratur () {
        return "Literartur/ubahLiteratur";
    }

}
