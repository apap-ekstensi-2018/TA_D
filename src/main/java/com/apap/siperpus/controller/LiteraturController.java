package com.apap.siperpus.controller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Controller
@RequestMapping("/literatur")
public class LiteraturController {
	private static final String PATH_FILE_UPLOAD = "//pdf//";
	
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
    }
    
    @RequestMapping("/upload")
    public String uploadKaryaTulis(@RequestParam("file") MultipartFile file, LiteraturModel literatur, RedirectAttributes redirectAttributes) {
    	if (!file.isEmpty()) {
    		try {	
	    		byte[] bytes = file.getBytes();
				Path path = Paths.get(PATH_FILE_UPLOAD + file.getOriginalFilename());
				Files.write(path, bytes);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
    	return "Literatur/uploadKaryaTulis";
    }
    
    /*@RequestMapping("/upload/submit")
    public String submitKaryaTulis(@Para) {
    	return "";
    }*/
}
