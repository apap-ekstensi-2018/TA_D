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

	@Override
	public PeminjamanLiteraturModel selectPeminjamanById(int id) {
		PeminjamanLiteraturModel obj = peminjamanLiteraturMapper.selectPeminjamanLiteraturByIdLiteratur(id);
		return obj;
	}

	@Override
	public void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur) {
		peminjamanLiteraturMapper.insertPeminjamanLiteratur(peminjamanLiteratur);
	}

	@Override
	public PeminjamanLiteraturModel selectJumlahPeminjaman(int id) {
		PeminjamanLiteraturModel obj = peminjamanLiteraturMapper.selectJumlahPeminjaman(id);
		return obj;
	}
}
