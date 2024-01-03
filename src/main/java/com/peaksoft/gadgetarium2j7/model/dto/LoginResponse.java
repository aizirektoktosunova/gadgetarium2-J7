package com.peaksoft.gadgetarium2j7.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class LoginResponse {
    private String token;
    private List<String> roleName;

}
