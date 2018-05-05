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
        return literaturMapper.selectAllLiteratur();
    }

    @Override
    public LiteraturModel selectLiteratur(int id)
    {
        log.info ("select literatur with id {}", id);
        return literaturMapper.selectLiteratur (id);
    }

    @Override
    public void ubahLiteratur(LiteraturModel literatur)
    {
        log.info("literatur"+literatur.getId());
        literaturMapper.ubahLiteratur(literatur);
    }


}
