package com.apap.controller;

import com.apap.model.SiperpusModel;
import com.apap.service.SiperpusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Primary
public class MainController {

    @Autowired
    SiperpusService siperpusDAO;



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

    @RequestMapping("/literatur/ubah/{id}")
    public String ubahLiteratur (Model model, @PathVariable(value = "id") int id)
    {
        model.addAttribute("id",id);
        return "Literartur/ubahLiteratur";
    }

    @RequestMapping(value="/literatur/ubah/{id}/",method = RequestMethod.POST)
    public String ubahLiteraturSubmit(
            @RequestParam(value = "id",required = false) int id,
            @RequestParam(value = "judul",required = false) String judul,
            @RequestParam(value = "penulis",required = false) String penulis,
            @RequestParam(value = "penerbit",required = false) String penerbit,
            @RequestParam(value = "jenis_literatur",required = false) String jenis_literatur,
            @RequestParam(value = "jumlah",required = false) int jumlah,
            @RequestParam(value = "status",required = false) int status)
    {
        SiperpusModel siperpus = new SiperpusModel(id,judul,penulis,penerbit,jenis_literatur,jumlah,status);
        siperpusDAO.ubahLiteratur(siperpus);
        return "success";
    }


}
