package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleManageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRolesList() {
        return roleService.getRolesList();
    }
}
