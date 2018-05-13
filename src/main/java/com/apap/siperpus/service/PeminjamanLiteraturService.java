package com.apap.siperpus.service;

import java.util.List;
import com.apap.siperpus.model.PeminjamanLiteraturModel;

public interface PeminjamanLiteraturService {
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	PeminjamanLiteraturModel selectPeminjamanLiteraturById(int id);
	
	void insertPeminjamanLiteratur(String id_literatur,
								   String username_peminjaman,
								   String tanggal_peminjaman,
								   String tanggal_pengembalian,
								   String status_peminjaman,
								   String id_surat);

	PeminjamanLiteraturModel selectJumlahPeminjaman(int id);

	void ubahPeminjaman(PeminjamanLiteraturModel peminjamanLiteratur);

	Integer selectLiteraturBasedOnTanggal (PeminjamanLiteraturModel peminjaman);
}
