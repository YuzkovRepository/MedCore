package com.example.MedCore.modules.security.service.impl;

import com.example.MedCore.modules.security.dto.PermissionDTO;
import com.example.MedCore.modules.security.entity.Permission;
import com.example.MedCore.modules.security.repository.PermissionRepository;
import com.example.MedCore.modules.security.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Long permissionId) {
        return permissionRepository.findById(permissionId).orElse(null);
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        return permissionRepository.findByPermissionName(permissionName).orElse(null);
    }

    @Override
    public Permission addPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setPermissionName(permissionDTO.getPermissionName());
        permission.setDescription(permissionDTO.getDescription());
        return permissionRepository.save(permission);
    }
}
