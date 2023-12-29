package com.peaksoft.gadgetarium2j7.model.dto.mapper.impl;

import com.peaksoft.gadgetarium2j7.model.dto.AuthRequest;
import com.peaksoft.gadgetarium2j7.model.dto.AuthResponse;
import com.peaksoft.gadgetarium2j7.model.dto.entity.User;
import com.peaksoft.gadgetarium2j7.model.dto.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuthMapper implements Mapper<AuthRequest, User, AuthResponse> {

    @Override
    public User mapToEntity(AuthRequest authRequest) {
        return User.builder()
                .name(authRequest.getName())
                .lastName(authRequest.getLastName())
                .email(authRequest.getEmail())
                .password(authRequest.getPassword())
                .repeatPassword(authRequest.getRepeatPassword())
                .createdDate(LocalDateTime.now())
                .build();
    }

    @Override
    public AuthResponse mapToResponse(User entity) {
        return AuthResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .created(entity.getCreatedDate())
                .roleName(entity.getRoles().get(0).getName())
                .build();
    }
}

