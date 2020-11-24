package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.RoleMapper;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRolesList() {
        return roleMapper.getRolesList();
    }
}
