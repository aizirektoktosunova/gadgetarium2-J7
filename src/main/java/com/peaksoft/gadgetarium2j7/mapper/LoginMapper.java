package com.peaksoft.gadgetarium2j7.mapper;

import com.peaksoft.gadgetarium2j7.model.dto.LoginResponse;
import com.peaksoft.gadgetarium2j7.model.entities.Role;
import com.peaksoft.gadgetarium2j7.model.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginMapper {
    public LoginResponse matToResponse(String token, User user) {
        List<String> roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
        }
        return LoginResponse.builder()
                .token(token)
                .roleName(roles)
                .build();
    }
}
