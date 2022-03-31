package com.vnaazleen.instrumentDelight.controller;

import com.vnaazleen.instrumentDelight.model.RoleModel;
import com.vnaazleen.instrumentDelight.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public RoleModel createNewRole(@RequestBody RoleModel roleModel) {
        return roleService.createNewRole(roleModel);
    }
}

