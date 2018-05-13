package com.apap.siperpus.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apap.siperpus.model.PeminjamanLiteraturModel;
import com.apap.siperpus.model.PengadaanLiteraturModel;
import com.apap.siperpus.model.UserAccountModel;
import com.apap.siperpus.service.PeminjamanLiteraturService;
import com.apap.siperpus.service.PeminjamanLiteraturServiceDatabase;
import com.apap.siperpus.service.PengadaanLiteraturService;
import com.apap.siperpus.service.PengadaanLiteraturServiceDatabase;
import com.apap.siperpus.service.UserAccountService;
import com.apap.siperpus.service.UserAccountServiceDatabase;

@Controller
@RequestMapping("/peminjaman")
public class PengadaanLiteraturController {
	private static final String ROLE_STAFF = "ROLE_STAF";
	
	@Autowired
	PengadaanLiteraturService pengadaanLiteraturDAO;
	
	@Autowired
	PeminjamanLiteraturService peminjamanLiteraturDAO;
	
	@Autowired
	UserAccountService userAccountDAO;
	
	@RequestMapping("/viewall")
	public String lihatDaftarPengadaanLiteratur(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		UserAccountModel user = userAccountDAO.selectUserAccountByUsername(username);
		
		
	    List<PengadaanLiteraturModel> pengadaanLiteraturs = new ArrayList<PengadaanLiteraturModel>();
	    List<PeminjamanLiteraturModel> peminjamanLiteraturs = new ArrayList<PeminjamanLiteraturModel>();
	    if(user.getRole().equals(ROLE_STAFF)) {
	    		pengadaanLiteraturs = pengadaanLiteraturDAO.selectAllPengadaanLiteratur();
	    }
	    else {
	    		peminjamanLiteraturs = peminjamanLiteraturDAO.selectPeminjamanLiteraturByUsername(user.getUsername());
	    }
	    
	    model.addAttribute("role", user.getRole());
	    model.addAttribute("pengadaanLiteraturs", pengadaanLiteraturs);
	    model.addAttribute("peminjamanLiteraturs", peminjamanLiteraturs);
	    
	    return "Peminjaman/daftarPeminjaman";
	}
}
