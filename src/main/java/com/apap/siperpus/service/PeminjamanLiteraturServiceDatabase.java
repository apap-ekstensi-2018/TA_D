package com.apap.siperpus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.siperpus.dao.PeminjamanLiteraturMapper;
import com.apap.siperpus.model.PeminjamanLiteraturModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanLiteraturServiceDatabase implements PeminjamanLiteraturService {

	@Autowired
	private PeminjamanLiteraturMapper peminjamanLiteraturMapper;
	
	@Override
	public List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur() {
		List<PeminjamanLiteraturModel> obj = peminjamanLiteraturMapper.selectAllPeminjamanLiteratur();
		return obj;
	}

	public PeminjamanLiteraturModel selectPeminjamanLiteraturById(int id) {
		log.info("Peminjaman Literatur {}", id);
		return peminjamanLiteraturMapper.selectPeminjamanLiteraturByIdLiteratur(id);
	}


	@Override
	public void insertPeminjamanLiteratur(String id_literatur,
										  String username_peminjaman,
										  String tanggal_peminjaman,
										  String tanggal_pengembalian,
										  String status_peminjaman,
										  String id_surat) {
		peminjamanLiteraturMapper.insertPeminjamanLiteratur(id_literatur,username_peminjaman,tanggal_peminjaman,tanggal_pengembalian,status_peminjaman,id_surat);
	}

	@Override
	public PeminjamanLiteraturModel selectJumlahPeminjaman(int id) {
		PeminjamanLiteraturModel obj = peminjamanLiteraturMapper.selectJumlahPeminjaman(id);
		return obj;
	}

	@Override
	public void ubahPeminjaman(PeminjamanLiteraturModel peminjamanLiteratur){
		peminjamanLiteraturMapper.ubahPeminjaman(peminjamanLiteratur);
	}

	@Override
	public Integer selectLiteraturBasedOnTanggal(PeminjamanLiteraturModel peminjaman){
		return peminjamanLiteraturMapper.selectLiteraturBasedOnTanggal(peminjaman);
	}
}
