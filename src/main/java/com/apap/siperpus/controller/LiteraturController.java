package com.apap.siperpus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;

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
    
    @RequestMapping("/literatur/viewall")
    public String lihatDaftarLiteratur(Model model) {
    		List<LiteraturModel> literaturs = literaturDAO.selectAllLiteratur();
        model.addAttribute ("literaturs", literaturs);
        return "Literatur/daftarLiteratur";
        
    		
    }
}
