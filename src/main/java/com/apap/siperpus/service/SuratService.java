package com.apap.siperpus.service;

import com.apap.siperpus.model.SuratReturnModel;

public interface SuratService {
    SuratReturnModel selectSurat(String id_surat);
}
