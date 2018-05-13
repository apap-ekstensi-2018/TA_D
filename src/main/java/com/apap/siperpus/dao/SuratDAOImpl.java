package com.apap.siperpus.dao;

import com.apap.siperpus.model.SuratModel;
import com.apap.siperpus.model.SuratReturnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SuratDAOImpl implements SuratDAO {
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public SuratReturnModel selectSurat(String id_surat){
        String url = "https://kelompok-c.herokuapp.com/api/surat/view/";
        SuratReturnModel surat = restTemplate.getForObject(url+id_surat, SuratReturnModel.class);
        return surat;
    }
}
