package com.peaksoft.gadgetarium2j7.model.dto.mapper;

public interface Mapper<RST, ENTITY, RNS> {
    ENTITY mapToEntity(RST rst);

    RNS mapToResponse(ENTITY entity);
}
