package com.apap.siperpus.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.apap.siperpus.model.PeminjamanLiteraturModel;


public interface PeminjamanLiteraturService {
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	PeminjamanLiteraturModel selectPeminjamanLiteraturById(int id);
	
	void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur);

	PeminjamanLiteraturModel selectJumlahPeminjaman(int id);

	void ubahPeminjaman(PeminjamanLiteraturModel peminjamanLiteratur);
	
	List<PeminjamanLiteraturModel> selectPeminjamanLiteraturByUsername(String username);
}
