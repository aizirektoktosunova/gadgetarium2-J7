package com.peaksoft.gadgetarium2j7.model.dto.mapper.impl;

import com.peaksoft.gadgetarium2j7.model.dto.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    // Исправленный метод mapToResponse, который принимает одну строку с именами ролей, разделенными запятой.
    public LoginResponse mapToResponse(String token, String roleNames) {
        return LoginResponse.builder()
                .roleName(roleNames) // Исходим из предположения, что LoginResponse.builder().roleName ожидает String.
                .token(token)
                .build();
    }


}
