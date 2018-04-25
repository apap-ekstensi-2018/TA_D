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

    LiteraturModel ubahLiteratur (LiteraturModel literatur);

}
