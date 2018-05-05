package com.apap.siperpus.controller;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
@RequestMapping("/literatur")
public class LiteraturController {
    @Autowired
    LiteraturService literaturDAO;

    @RequestMapping("/tambah")
    public String tambah() {
        return "Literatur/tambahliteratur";
    }

    @RequestMapping(value = "/tambah", method = RequestMethod.POST)
    public @ResponseBody boolean submitLiteratur(Model model, @ModelAttribute("data") String data){
        try {
        	JSONArray dataArray = new JSONArray(data);
            LiteraturModel literatur = literaturDAO.selectLiteraturByJudul(dataArray.getJSONObject(0).getString("value"));
            if(literatur == null){
                String judul = dataArray.getJSONObject(0).getString("value");
                String penulis = dataArray.getJSONObject(1).getString("value");
                String penerbit = dataArray.getJSONObject(2).getString("value");
                String jenis_literatur = dataArray.getJSONObject(3).getString("value");
                int jumlah = dataArray.getJSONObject(4).getInt("value");
                literaturDAO.insertLiteratur(judul, penulis, penerbit, jenis_literatur, jumlah);
                return true;
            }
        } catch (Exception e) {
			// TODO: handle exception
		}
    	return false;
    }

    @RequestMapping("/delete/{id}")
    public String deleteLiteratur(@PathVariable(value = "id") int id){
        literaturDAO.deleteLiteratur(id);
        return "Literatur/daftarLiteratur";
    }
}
