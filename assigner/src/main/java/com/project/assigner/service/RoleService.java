package com.project.assigner.service;

import com.project.assigner.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Long roleId);
}
