package com.apap.siperpus.service;

import java.util.List;

import com.apap.siperpus.model.PengadaanLiteraturModel;

public interface PengadaanLiteraturService {
	List<PengadaanLiteraturModel> selectAllPengadaanLiteratur();
	
	List<PengadaanLiteraturModel> selectPengadaanLiteraturByUsername(String username);
	
	PengadaanLiteraturModel selectPengadaanLiteraturByJudul(String judul);
	
	void insertPengadaanLiteratur(PengadaanLiteraturModel pengadaanLiteratur);
}
