package com.apap.service;

import com.apap.dao.SiperpusMapper;
import com.apap.model.SiperpusModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SiperpusServiceDatabase implements SiperpusService {
    @Override
    public SiperpusModel ubahLiteratur(SiperpusModel siperpus)
    {
        log.info("literatur");
        return SiperpusMapper.ubahLiteratur(siperpus);
    }
}
