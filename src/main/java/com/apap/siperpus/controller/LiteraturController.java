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
import java.util.HashSet;
import java.util.Set;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.service.LiteraturService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.*;

/**
 * Created on : April 24, 2018 Author : Kurniawan Hendi Wijaya Name : Hendi
 */
@Controller
@RequestMapping("/literatur")
public class LiteraturController {
	private static final String BASE_PATH = "C://Users//Gani Gemilar//Documents//workspace-sts-3.9.2.RELEASE//TA_D//";
	private static final String PATH_FILE_UPLOAD = BASE_PATH + "pdf//";

	@Autowired
	LiteraturService literaturDAO;

	@RequestMapping("/ubah/{id}")
	public String ubahLiteratur(Model model, @PathVariable(value = "id") int id) {
		System.out.println("ubah Literatur : " + id);
		LiteraturModel literatur = literaturDAO.selectLiteratur(id);
		model.addAttribute("literatur", literatur);
		return "Literatur/ubahLiteratur";
	}

	@RequestMapping(value = "/ubah/submit", method = RequestMethod.POST)
	public String ubahLiteraturSubmit(@ModelAttribute LiteraturModel literaturModel) {
		literaturDAO.ubahLiteratur(literaturModel);
		return "redirect:/literatur/viewall";
	}

	@RequestMapping("/view/{id}")
	public String viewLiteratur(Model model, @PathVariable(value = "id") int id) {
		LiteraturModel literatur = literaturDAO.selectLiteratur(id);
		model.addAttribute("literatur", literatur);
		return "Literatur/detailLiteratur";
	}

	@RequestMapping("/viewall")
	public String lihatDaftarLiteratur(Model model) {
		List<LiteraturModel> literaturs = literaturDAO.selectAllLiteratur();
		model.addAttribute("literaturs", literaturs);
		return "Literatur/daftarLiteratur";
	}

	@RequestMapping("/tambah")
	public String tambah() {
		return "Literatur/tambahliteratur";
	}

	@RequestMapping(value = "/tambah", method = RequestMethod.POST)
	public @ResponseBody boolean submitLiteratur(Model model, @ModelAttribute("data") String data) {
		try {
			JSONArray dataArray = new JSONArray(data);
			LiteraturModel literatur = literaturDAO
					.selectLiteraturByJudul(dataArray.getJSONObject(0).getString("value"));
			if (literatur == null) {
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
	public String deleteLiteratur(@PathVariable(value = "id") int id) {
		literaturDAO.deleteLiteratur(id);
		return "redirect:/literatur/viewall";
	}

	@RequestMapping(value = "/upload/submit", method = RequestMethod.POST)
	public String submitKaryaTulis(@RequestParam("file") MultipartFile file, LiteraturModel literatur, RedirectAttributes redirectAttributes) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(PATH_FILE_UPLOAD + file.getOriginalFilename());
				//System.err.println(path.toString());
				Files.write(path, bytes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.println("OK");
		return "Literatur/uploadKaryaTulis";
	}

	@RequestMapping("/upload")
	public String uploadKaryaTulis() {
		return "Literatur/uploadKaryaTulis";
	}

    @RequestMapping("/cari/")
    public String cariLiteratur() {
        return "Literatur/cariLiteratur";
    }

    @RequestMapping("/cari")
    public String submitCari(Model model, @RequestParam("judul") String judul, @RequestParam("penulis") String penulis, @RequestParam("penerbit") String penerbit,  @RequestParam("jenis_literatur") String jenis_literatur) {
        Set<LiteraturModel> literaturs = new HashSet<>();
        if(judul != "") {
            literaturs.addAll(literaturDAO.selectLiteraturWithConditionTitle(judul));
        }
        if(penulis != "") {
            literaturs.addAll(literaturDAO.selectLiteraturWithConditionAuthor(penulis));
        }
        if(penerbit != "") {
            literaturs.addAll(literaturDAO.selectLiteraturWithConditionPublisher(penerbit));
        }
        if(jenis_literatur != "") {
            literaturs.addAll(literaturDAO.selectLiteraturWithConditionTypeOfLiteature(jenis_literatur));
        }
        model.addAttribute ("literaturs", literaturs);
        return "Literatur/daftarLiteratur";
    }
}
