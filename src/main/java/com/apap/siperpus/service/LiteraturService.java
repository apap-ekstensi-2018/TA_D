package com.apap.siperpus.service;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.model.PeminjamanLiteraturModel;

import java.util.List;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
public interface LiteraturService {


    List<LiteraturModel> selectAllLiteratur ();

    LiteraturModel selectLiteratur(int id);

    void ubahLiteratur (LiteraturModel literatur);

    LiteraturModel selectLiteraturByJudul(String judul);

    void insertLiteratur(String judul, String penulis, String penerbit, String jenis_literatur, int jumlah);

    void deleteLiteratur(int id);

    List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur ();

    PeminjamanLiteraturModel selectPeminjamanLiteraturById(String id_literatur);

    List<LiteraturModel> selectLiteraturWithConditionTitle(String judul);

    List<LiteraturModel> selectLiteraturWithConditionAuthor(String penulis);

    List<LiteraturModel> selectLiteraturWithConditionPublisher(String penerbit);

    List<LiteraturModel> selectLiteraturWithConditionTypeOfLiteature(String jenis_literatur);

    LiteraturModel selectJenisLiteratur(int id);
    
}
