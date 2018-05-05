package com.apap.siperpus.dao;

import com.apap.siperpus.model.LiteraturModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
