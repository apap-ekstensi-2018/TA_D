package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.apap.siperpus.model.PengadaanLiteraturModel;

@Mapper
public interface PengadaanLiteraturMapper {
	
	@Select("SELECT * FROM pengadaan_literatur WHERE username=#{username}")
	List<PengadaanLiteraturModel> selectPengadaanLiteraturByUsername(String username);
	
	@Select("SELECT * FROM pengadaan_literatur WHERE judul=#{judul}")
	@Results({
		@Result(property="usernameRequester", column="username_requester")
	})
	PengadaanLiteraturModel selectPengadaanLiteraturByJudul(String judul);
	
	@Select("SELECT * FROM pengadaan_literatur")
	List<PengadaanLiteraturModel> selectAllPengadaanLiteratur();
	
	@Insert("INSERT INTO pengadaan_literatur VALUES ("
			+ "#{usernameRequester},"
			+ "#{judul},"
			+ "#{penulis},"
			+ "#{penerbit},"
			+ "#{status}"
			+ ")")
	void insertPengadaanLiteratur(PengadaanLiteraturModel pengadaanLiteratur);
}
