package com.apap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.apap.model.PegawaiModel;

@Mapper
public interface PegawaiMapper {
	
	public PegawaiModel selectPegawaiByNIP(String nip);
	
	public List<PegawaiModel> selectAllPegawai();
	
	public PegawaiModel selectPegawaiById(int id);
	
	public PegawaiModel selectPegawaiByUsername(String username);
}