package com.apap.siperpus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.siperpus.dao.PengadaanLiteraturMapper;
import com.apap.siperpus.model.PengadaanLiteraturModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PengadaanLiteraturServiceDatabase implements PengadaanLiteraturService{
	@Autowired
    private PengadaanLiteraturMapper pengadaanLiteraturMapper;
	
	@Override
	public List<PengadaanLiteraturModel> selectAllPengadaanLiteratur() {
		return pengadaanLiteraturMapper.selectAllPengadaanLiteratur();
	}

	@Override
	public List<PengadaanLiteraturModel> selectPengadaanLiteraturByUsername(String username) {
		return pengadaanLiteraturMapper.selectPengadaanLiteraturByUsername(username);
	}

}
