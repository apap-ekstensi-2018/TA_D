package com.apap.siperpus.dao;

import com.apap.siperpus.model.LiteraturModel;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT id,judul,penulis,penerbit,jenis_literatur,jumlah,status from literatur where id=#{id}")
    LiteraturModel selectLiteratur(@Param("id") int id);

    @Update("Update literatur set judul = #{judul},penulis = #{penulis}, penerbit = #{penerbit}, jenis_literatur = #{jenis_literatur}, jumlah = #{jumlah}, status = #{status} where id = #{id};")
    void ubahLiteratur(LiteraturModel literatur);
}
