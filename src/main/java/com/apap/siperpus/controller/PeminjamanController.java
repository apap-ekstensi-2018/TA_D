package com.apap.siperpus.controller;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.model.PeminjamanLiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peminjaman")
public class PeminjamanController {

    @Autowired
    LiteraturService literaturDAO;

    @RequestMapping("/view/{id_literatur}")
    public String viewLiteratur(Model model, @PathVariable(value = "id_literatur") String id_literatur) {
        PeminjamanLiteraturModel peminjamanLiteratur = literaturDAO.selectPeminjamanLiteraturById(id_literatur);
        model.addAttribute("peminjamanLiteratur", peminjamanLiteratur);
        return "Peminjaman/detailPeminjaman";
    }
}
