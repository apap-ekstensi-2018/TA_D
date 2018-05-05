package com.apap.siperpus.dao;

import com.apap.siperpus.model.LiteraturModel;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
=======
import org.apache.ibatis.annotations.*;
>>>>>>> master

import java.util.List;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Mapper
public interface LiteraturMapper {
    @Select("select * from literatur")
    List<LiteraturModel> selectAllLiteratur ();
<<<<<<< HEAD
=======

    @Update("Update student set judul = #{literatur.judul}," +
            "penulis = #{literatur.penulis}," +
            "penerbit = #{literatur.penerbit}," +
            "jenis_literatur = #{literatur.jenis_literatur}," +
            "jumlah = #{literatur.jumlah}," +
            "status = #{literatur.status}" +
            "where id = #{literatur.ic}")
    LiteraturModel ubahLiteratur(@Param("literatur") LiteraturModel literatur);

    @Select("select * from literatur where judul = #{judul}")
    LiteraturModel selectLiteraturByJudul(@Param("judul") String judul);

    @Update("insert into literatur(judul, penulis, penerbit, jenis_literatur, jumlah, status)" +
            "values(#{judul},#{penulis},#{penerbit},#{jenis_literatur},#{jumlah},1)")
    void insertLiteratur(@Param("judul") String judul, @Param("penulis") String penulis, @Param("penerbit") String penerbit,
                         @Param("jenis_literatur") String jenis_literatur, @Param("jumlah") int jumlah);

    @Delete("delete from literatur where id = #{id}")
    void deleteLiteratur(@Param("id") int id);
>>>>>>> master
}
