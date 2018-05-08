package com.apap.siperpus.service;

import com.apap.siperpus.model.PengadaanLiteraturModel;
import java.util.List;
import com.apap.siperpus.model.PeminjamanLiteraturModel;

public interface PeminjamanLiteraturService {
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	PeminjamanLiteraturModel selectPeminjamanById(int id);
	
	void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur);

	PengadaanLiteraturModel selectJumlahPeminjaman(int id);
}
