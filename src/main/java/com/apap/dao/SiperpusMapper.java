package com.apap.dao;

import java.util.List;

import com.apap.model.SiperpusModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SiperpusMapper
{
    @Update("Update student set judul = #{siperpus.judul}," +
            "penulis = #{siperpus.penulis}," +
            "penerbit = #{siperpus.penerbit}," +
            "jenis_literatur = #{siperpus.jenis_literatur}," +
            "jumlah = #{siperpus.jumlah}," +
            "status = #{siperpus.status}" +
            "where id = #{siperpus.ic}")
    SiperpusModel ubahLiteratur(@Param("siperpus") SiperpusModel siperpus);
}
