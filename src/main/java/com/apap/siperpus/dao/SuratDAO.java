package com.apap.siperpus.dao;

import com.apap.siperpus.model.SuratModel;
import com.apap.siperpus.model.SuratReturnModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
interface SuratDAO {
    SuratReturnModel selectSurat(String id_surat);
}
