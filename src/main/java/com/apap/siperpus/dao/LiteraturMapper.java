package com.apap.siperpus.dao;

import com.apap.siperpus.model.LiteraturModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

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

    @Update("Update literatur set judul = #{literatur.judul}," +
            "penulis = #{literatur.penulis}," +
            "penerbit = #{literatur.penerbit}," +
            "jenis_literatur = #{literatur.jenis_literatur}," +
            "jumlah = #{literatur.jumlah}," +
            "status = #{literatur.status}" +
            " where id = #{literatur.id}")
    void ubahLiteratur(@Param("literatur") LiteraturModel literatur);

    @Select("select * from literatur where judul = #{judul}")
    LiteraturModel selectLiteraturByJudul(@Param("judul") String judul);

    @Update("insert into literatur(judul, penulis, penerbit, jenis_literatur, jumlah, status)" +
            "values(#{judul},#{penulis},#{penerbit},#{jenis_literatur},#{jumlah},1)")
    void insertLiteratur(@Param("judul") String judul, @Param("penulis") String penulis, @Param("penerbit") String penerbit,
                         @Param("jenis_literatur") String jenis_literatur, @Param("jumlah") int jumlah);

    @Delete("delete from literatur where id = #{id}")
    void deleteLiteratur(@Param("id") int id);

    @Select("select * from literatur where id = #{id}")
    LiteraturModel selectLiteratur(@Param("id") int id);

    @Select("select * from literatur where judul like CONCAT('%',#{judul},'%')")
    List<LiteraturModel> selectLiteraturWithConditionTitle(@Param("judul") String judul);

    @Select("select * from literatur where penulis like CONCAT('%',#{penulis},'%')")
    List<LiteraturModel> selectLiteraturWithConditionAuthor(@Param("penulis") String penulis);

    @Select("select * from literatur where penerbit like CONCAT('%',#{penerbit},'%')")
    List<LiteraturModel> selectLiteraturWithConditionPublisher(@Param("penerbit") String penerbit);

    @Select("select * from literatur where jenis_literatur like CONCAT('%',#{jenis_literatur},'%')")
    List<LiteraturModel> selectLiteraturWithConditionTypeOfLiteature(@Param("jenis_literatur") String jenis_literatur);
}
