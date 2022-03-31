package com.vnaazleen.instrumentDelight.service;

import com.vnaazleen.instrumentDelight.repository.RoleRepository;
import com.vnaazleen.instrumentDelight.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleModel createNewRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }
}
