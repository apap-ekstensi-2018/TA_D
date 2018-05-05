package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.apap.siperpus.model.PegawaiModel;

@Mapper
public interface PegawaiMapper {
	
	@Select("SELECT * FROM pegawai WHERE nip=#{nip}")
	@Results({
		@Result(property="isStaf", column="is_staf")
	})
	public PegawaiModel selectPegawaiByNIP(String nip);
	
	@Select("SELECT * FROM pegawai")
	@Results({
		@Result(property="isStaf", column="is_staf")
	})
	public List<PegawaiModel> selectAllPegawai();
	
	@Select("SELECT * FROM pegawai WHERE id=#{id}")
	@Results({
		@Result(property="isStaf", column="is_staf")
	})
	public PegawaiModel selectPegawaiById(int id);
	
	@Select("SELECT * FROM pegawai WHERE username=#{username}")
	@Results({
		@Result(property="isStaf", column="is_staf")
	})
	public PegawaiModel selectPegawaiByUsername(String username);
}
