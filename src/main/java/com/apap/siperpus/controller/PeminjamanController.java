package com.apap.siperpus.controller;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.model.PeminjamanLiteraturModel;
import com.apap.siperpus.model.SuratReturnModel;
import com.apap.siperpus.service.LiteraturService;
import com.apap.siperpus.service.SuratService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peminjaman")
public class PeminjamanController {

    @Autowired
    LiteraturService literaturDAO;

    @Autowired
    SuratService suratDAO;

    @RequestMapping("/tambah")
    public String tambahPeminjaman(Model model) {

        return "Peminjaman/tambahPeminjaman";
    }

    @RequestMapping("/view/{id_literatur}")
    public String viewPeminjaman(Model model, @PathVariable(value = "id_literatur") String id_literatur) {
        PeminjamanLiteraturModel peminjamanLiteratur = literaturDAO.selectPeminjamanLiteraturById(id_literatur);
        model.addAttribute("tanggal_masuk", formatTanggal(peminjamanLiteratur.getTanggal_peminjaman()));
        model.addAttribute("tanggal_keluar", formatTanggal(peminjamanLiteratur.getTanggal_pengembalian()));
        model.addAttribute("peminjamanLiteratur", peminjamanLiteratur);
        model.addAttribute("judul_literatur", selectJudulLiteraturById(peminjamanLiteratur.getId_literatur()));
        return "Peminjaman/detailPeminjaman";
    }

    @RequestMapping(value="/tambah", method=RequestMethod.POST)
    public @ResponseBody boolean tambahPeminjaman(Model model, @ModelAttribute("data") String data) {

        JSONArray dataArray = new JSONArray(data);

        return true;
    }

    @RequestMapping(value="/select/literatur", method= RequestMethod.GET)
    public ResponseEntity<List<LiteraturModel>> selectLiteratur(Model model)
    {
        List<LiteraturModel> literaturModels = literaturDAO.selectAllLiteratur();
        return new ResponseEntity<List<LiteraturModel>>(literaturModels, HttpStatus.OK);
    }

    @RequestMapping(value="/getJenisLiteratur/{literatur}", method= RequestMethod.GET)
    public ResponseEntity<String> getJenisLiteratur(Model model, @PathVariable(value = "literatur") int literatur)
    {
        LiteraturModel literaturModels = literaturDAO.selectLiteratur(literatur);
        return new ResponseEntity<String>(literaturModels.getJenis_literatur(), HttpStatus.OK);
    }

    @RequestMapping("/surat/view/{id_literatur}")
    public ResponseEntity<SuratReturnModel>  getSurat(Model model, @PathVariable(value = "id_literatur") String id_literatur)
    {
        SuratReturnModel surat = suratDAO.selectSurat(id_literatur);
        return new ResponseEntity<SuratReturnModel>(surat, HttpStatus.OK);
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
