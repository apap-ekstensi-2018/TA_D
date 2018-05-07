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
        model.addAttribute("tanggal_masuk", formatTanggal(peminjamanLiteratur.getTanggal_peminjaman()));
        model.addAttribute("tanggal_keluar", formatTanggal(peminjamanLiteratur.getTanggal_pengembalian()));
        model.addAttribute("peminjamanLiteratur", peminjamanLiteratur);
        model.addAttribute("judul_literatur", selectJudulLiteraturById(peminjamanLiteratur.getId_literatur()));
        return "Peminjaman/detailPeminjaman";
    }

    public String selectJudulLiteraturById(int id)
    {
        LiteraturModel literatur = literaturDAO.selectLiteratur(id);
        return literatur.getJudul();
    }

    public String formatTanggal(String tgl)
    {
        String[] format = tgl.split("-");
        return format[2] + " " + bulan(format[1]) + " " + format[0];
    }

    public String bulan(String bln){
        String namaBulan;
        switch (bln){
            case "01":
                namaBulan= "Januari";
                break;
            case "02":
                namaBulan= "Februari";
                break;
            case "03":
                namaBulan = "Maret";
                break;
            case "04":
                namaBulan = "April";
                break;
            case "05":
                namaBulan = "Mei";
                break;
            case "06":
                namaBulan = "Juni";
                break;
            case "07":
                namaBulan = "Juli";
                break;
            case "08":
                namaBulan = "Agustus";
                break;
            case "09":
                namaBulan = "September";
                break;
            case "10":
                namaBulan = "Oktober";
                break;
            case "11":
                namaBulan = "November";
                break;
            case "12":
                namaBulan = "Desember";
                break;
            default: namaBulan = "Invalid Month";
                break;
        }
        return namaBulan;
    }
}
