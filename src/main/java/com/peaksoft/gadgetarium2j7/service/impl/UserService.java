package com.peaksoft.gadgetarium2j7.service.impl;

import com.peaksoft.gadgetarium2j7.model.dto.AuthRequest;
import com.peaksoft.gadgetarium2j7.model.dto.AuthResponse;
import com.peaksoft.gadgetarium2j7.model.dto.entity.Role;
import com.peaksoft.gadgetarium2j7.model.dto.entity.User;
import com.peaksoft.gadgetarium2j7.model.dto.mapper.impl.AuthMapper;
import com.peaksoft.gadgetarium2j7.repository.RoleRepository;
import com.peaksoft.gadgetarium2j7.repository.UserRepository;
import com.peaksoft.gadgetarium2j7.service.ServiceLayer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService implements ServiceLayer<AuthRequest, AuthResponse> {

    final AuthMapper userMapper;
    final UserRepository repository;
    final PasswordEncoder passwordEncoder;
    final RoleRepository roleRepository;

    @Override
    public AuthResponse save(AuthRequest requests) {
        User user = userMapper.mapToEntity(requests);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRepeatPassword(passwordEncoder.encode(user.getRepeatPassword()));
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("USER");
        if (role == null) {
            role = new Role("USER");
        }
        roles.add(role);
        user.setRoles(roles);
        return userMapper.mapToResponse(repository.save(user));
    }


    @Override
    public AuthResponse findById(Long id) {
        return null;
    }

    @Override
    public List<AuthResponse> findAll() {
        return null;
    }

    @Override
    public AuthResponse update(Long id, AuthRequest authRequest) {
        return null;
    }

    @Override
    public AuthResponse delete(Long id) {
        return null;
    }

}

