package com.apap.siperpus.service;

import com.apap.siperpus.dao.LiteraturMapper;
import com.apap.siperpus.model.LiteraturModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Slf4j
@Service
public class LiteraturServiceDatabase implements LiteraturService {
    @Autowired
    private LiteraturMapper literaturMapper;

    @Override
    public List<LiteraturModel> selectAllLiteratur(){
        log.info("Select all literatur");
        return literaturMapper.selectAllLiteratur();
    }

    @Override
    public LiteraturModel selectLiteraturByJudul(String judul){
        log.info("Select literatur by judul "+judul);
        return literaturMapper.selectLiteraturByJudul(judul);
    }

    @Override
    public void insertLiteratur(String judul, String penulis, String penerbit, String jenis_literatur, int jumlah){
        log.info("Insert literatur judul "+judul);
        literaturMapper.insertLiteratur(judul, penulis, penerbit, jenis_literatur, jumlah);
    }
}
