package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.apap.siperpus.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {
	
	@Select("SELECT * FROM mahasiswa WHERE npm=#{npm}")
	public MahasiswaModel selectMahasiswaByNPM(String npm);
	
	@Select("SELECT * FROM mahasiswa")
	public List<MahasiswaModel> selectAllMahasiswa();
	
	@Select("SELECT * FROM mahasiswa WHERE id=#{id}")
	public MahasiswaModel selectMahasiswaById(int id);
	
	@Select("SELECT * FROM mahasiswa WHERE username=#{username}")
	public MahasiswaModel selectMahasiswaByUsername(String username);
}
