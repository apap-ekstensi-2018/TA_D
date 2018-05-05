package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.apap.siperpus.model.PengadaanLiteraturModel;

@Mapper
public interface PengadaanLiteraturMapper {
	
	@Select("SELECT * FROM pengadaan_literatur WHERE username=#{username}")
	@Results({
		@Result(property="usernameRequester", column="username_requester")
	})
	PengadaanLiteraturModel selectPengadaanLiteraturByUsername(String username);
	
	@Select("SELECT * FROM pengadaan_literatur WHERE judul=#{judul}")
	@Results({
		@Result(property="usernameRequester", column="username_requester")
	})
	PengadaanLiteraturModel selectPengadaanLiteraturByJudul(String judul);
	
	@Select("SELECT * FROM pengadaan_literatur")
	@Results({
		@Result(property="usernameRequester", column="username_requester")
	})
	List<PengadaanLiteraturModel> selectAllPengadaanLiteratur();
}
