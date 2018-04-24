package com.apap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.apap.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {
	
	public MahasiswaModel selectMahasiswaByNPM(String npm);
	
	public List<MahasiswaModel> selectAllMahasiswa();
	
	public MahasiswaModel selectMahasiswaById(int id);
	
	public MahasiswaModel selectMahasiswaByUsername(String username);
}
