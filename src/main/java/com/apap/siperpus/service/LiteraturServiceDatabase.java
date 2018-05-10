package com.apap.siperpus.service;

import com.apap.siperpus.dao.LiteraturMapper;
import com.apap.siperpus.dao.PeminjamanLiteraturMapper;
import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.model.PeminjamanLiteraturModel;
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

    @Autowired
    private PeminjamanLiteraturMapper peminjamanLiteraturMapper;

    @Override
    public List<LiteraturModel> selectAllLiteratur(){
        log.info("Select all literatur");
        return literaturMapper.selectAllLiteratur();
    }

    @Override
    public LiteraturModel selectLiteratur(int id)
    {
        log.info ("select literatur with id {}", id);
        LiteraturModel modelExist = literaturMapper.selectLiteratur (id);
        // detil peminjaman select by literatur id
        PeminjamanLiteraturModel peminjamanExist = peminjamanLiteraturMapper.selectJumlahPeminjaman(id);
        modelExist.setJumlah(modelExist.getJumlah()-peminjamanExist.getJumlahpeminjaman());
        return literaturMapper.selectLiteratur (id);
    }

    @Override
    public void ubahLiteratur(LiteraturModel literatur)
    {
        log.info("literatur"+literatur.getId());
        literaturMapper.ubahLiteratur(literatur);
    }

    public LiteraturModel selectLiteraturByJudul(String judul){
        log.info("Select literatur by judul "+judul);
        return literaturMapper.selectLiteraturByJudul(judul);
    }

    @Override
    public void insertLiteratur(String judul, String penulis, String penerbit, String jenis_literatur, int jumlah){
        log.info("Insert literatur judul "+judul);
        literaturMapper.insertLiteratur(judul, penulis, penerbit, jenis_literatur, jumlah);
    }

    @Override
    public void deleteLiteratur(int id){
        log.info("Delete literatur with id "+id);
        literaturMapper.deleteLiteratur(id);
    }

    @Override
    public List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur(){
        log.info("Select all literatur");
        return peminjamanLiteraturMapper.selectAllPeminjamanLiteratur();
    }

    @Override
    public PeminjamanLiteraturModel selectPeminjamanLiteraturById(String id_literatur){
        log.info("select by literatur id" + id_literatur);
        return peminjamanLiteraturMapper.selectPeminjamanLiteraturById(id_literatur);
    }
}
