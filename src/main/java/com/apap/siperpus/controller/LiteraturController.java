package com.apap.siperpus.controller;
import java.util.List;

<<<<<<< HEAD
import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
>>>>>>> master

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
@RequestMapping("/literatur")
public class LiteraturController {
<<<<<<< HEAD

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

    @RequestMapping("/literatur/view/{id}")
    public String viewLiteratur(Model model, @PathVariable(value = "id") int id)
    {
        LiteraturModel literatur = literaturDAO.selectLiteratur(id);
        model.addAttribute("literatur",literatur);
        return "Literatur/detailLiteratur";
=======
	@Autowired
	LiteraturService literaturDAO;
    
    @RequestMapping("/viewall")
    public String lihatDaftarLiteratur(Model model) {
    		List<LiteraturModel> literaturs = literaturDAO.selectAllLiteratur();
        model.addAttribute ("literaturs", literaturs);
        return "Literatur/daftarLiteratur";
    }

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
        return "redirect:/literatur/viewall";
>>>>>>> master
    }
}
