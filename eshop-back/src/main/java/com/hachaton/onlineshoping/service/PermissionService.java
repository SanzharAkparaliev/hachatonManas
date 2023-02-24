package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.model.PermissionDTO;

import java.util.List;

public interface PermissionService {

    PermissionDTO getPermission(Long id);

    List<PermissionDTO> getAllPermissions();

}