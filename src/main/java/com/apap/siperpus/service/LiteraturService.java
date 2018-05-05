package com.apap.siperpus.service;

import com.apap.siperpus.model.LiteraturModel;

import java.util.List;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
public interface LiteraturService {


    List<LiteraturModel> selectAllLiteratur ();

<<<<<<< HEAD
    LiteraturModel selectLiteratur(int id);

    void ubahLiteratur (LiteraturModel literatur);

=======
    LiteraturModel selectLiteraturByJudul(String judul);

    void insertLiteratur(String judul, String penulis, String penerbit, String jenis_literatur, int jumlah);

    void deleteLiteratur(int id);
>>>>>>> master
}
