package com.apap.siperpus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.siperpus.dao.PengadaanLiteraturMapper;
import com.apap.siperpus.model.PengadaanLiteraturModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PengadaanLiteraturServiceDatabase implements PengadaanLiteraturService {
	@Autowired
	private PengadaanLiteraturMapper pengadaanLiteraturMapper;
	
	@Override
	public List<PengadaanLiteraturModel> selectAllPengadaanLiteratur() {
		List<PengadaanLiteraturModel> obj = pengadaanLiteraturMapper.selectAllPengadaanLiteratur();
		return obj;
	}

	@Override
	public List<PengadaanLiteraturModel> selectPengadaanLiteraturByUsername(String usernameRequester) {
		List<PengadaanLiteraturModel> obj = pengadaanLiteraturMapper.selectPengadaanLiteraturByUsernameRequester(usernameRequester);
		return obj;
	}

	@Override
	public PengadaanLiteraturModel selectPengadaanLiteraturByJudul(String judul) {
		PengadaanLiteraturModel obj = pengadaanLiteraturMapper.selectPengadaanLiteraturByJudul(judul);
		return obj;
	}

	@Override
	public void insertPengadaanLiteratur(PengadaanLiteraturModel pengadaanLiteratur) {
		pengadaanLiteraturMapper.insertPengadaanLiteratur(pengadaanLiteratur);
	}
}
