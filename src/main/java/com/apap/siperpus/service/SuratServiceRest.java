package com.apap.siperpus.service;

import com.apap.siperpus.dao.SuratDAOImpl;
import com.apap.siperpus.model.SuratReturnModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class SuratServiceRest implements SuratService{
    @Autowired
    private SuratDAOImpl suratDAO;

    @Override
    public SuratReturnModel selectSurat(String id_surat){
        return suratDAO.selectSurat(id_surat);
    }
}
