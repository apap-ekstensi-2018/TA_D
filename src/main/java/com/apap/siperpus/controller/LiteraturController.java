package com.apap.siperpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
public class LiteraturController {
    @RequestMapping("/literatur/tambah")
    public String tambah() {
        return "Literatur/tambahliteratur";
    }

    @RequestMapping(value = "/literatur/tambah", method = RequestMethod.POST)
    public String submitTambah(Model model) {
        return null;
    }
}
