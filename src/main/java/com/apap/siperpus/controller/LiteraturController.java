package com.apap.siperpus.controller;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
public class LiteraturController {

    @Autowired
    LiteraturService literaturDAO;

    @RequestMapping("/literatur/tambah")
    public String tambahliteratur () {
        return "Literatur/tambahliteratur";
    }

    @RequestMapping("/literatur/ubah/{id}")
    public String ubahLiteratur (Model model, @PathVariable(value = "id") int id)
    {
        LiteraturModel literatur = literaturDAO.selectLiteratur(id);
        model.addAttribute("literatur",literatur);
        return "Literatur/ubahLiteratur";
    }

    @RequestMapping(value="/literatur/ubah/submit",method = RequestMethod.POST)
    public String ubahLiteraturSubmit(
            @RequestParam(value = "id",required = false) int id,
            @RequestParam(value = "judul",required = false) String judul,
            @RequestParam(value = "penulis",required = false) String penulis,
            @RequestParam(value = "penerbit",required = false) String penerbit,
            @RequestParam(value = "jenis_literatur",required = false) String jenis_literatur,
            @RequestParam(value = "jumlah",required = false) int jumlah,
            @RequestParam(value = "status",required = false) int status)
    {
        LiteraturModel literatur = new LiteraturModel(id,judul,penulis,penerbit,jenis_literatur,jumlah,status);
        literaturDAO.ubahLiteratur(literatur);
        return "Literatur/tambah";
    }
}
