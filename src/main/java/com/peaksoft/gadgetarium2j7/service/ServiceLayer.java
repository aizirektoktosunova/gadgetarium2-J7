package com.peaksoft.gadgetarium2j7.service;

import java.util.List;

public interface ServiceLayer<RQST, RSPNS> {

    RSPNS save(RQST rqst);

    RSPNS findById(Long id);

    List<RSPNS> findAll();

    RSPNS update(Long id, RQST rqst);

    RSPNS delete(Long id);
}
