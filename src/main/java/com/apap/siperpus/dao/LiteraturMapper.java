package com.apap.siperpus.dao;

import com.apap.siperpus.model.LiteraturModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Mapper
public interface LiteraturMapper {
    @Select("SELECT * FROM literatur")
    List<LiteraturModel> selectAllLiteratur ();

    @Update("Update student set judul = #{literatur.judul}," +
            "penulis = #{literatur.penulis}," +
            "penerbit = #{literatur.penerbit}," +
            "jenis_literatur = #{literatur.jenis_literatur}," +
            "jumlah = #{literatur.jumlah}," +
            "status = #{literatur.status}" +
            "where id = #{literatur.ic}")
    LiteraturModel ubahLiteratur(@Param("siperpus") LiteraturModel literatur);
}
