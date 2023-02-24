package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Permission;
import com.hachaton.onlineshoping.model.PermissionDTO;
import com.hachaton.onlineshoping.repository.PermissionRepository;
import com.hachaton.onlineshoping.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    @Override
    public PermissionDTO getPermission(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permission by id: " + id + " cannot be found !"));

        return permission.toModel();
    }

    @Override
    public List<PermissionDTO> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(Permission::toModel).collect(Collectors.toList());
    }
}
