package com.apap.siperpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
public class LiteraturController {
    @RequestMapping("/literatur/tambah")
    public String tambahliteratur () {
        return "Literatur/tambahliteratur";
    }
}
