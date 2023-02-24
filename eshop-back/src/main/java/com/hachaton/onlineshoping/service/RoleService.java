package com.hachaton.onlineshoping.service;


import com.hachaton.onlineshoping.model.RequestNewRole;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity<?> register(RequestNewRole role);

    ResponseEntity<?> getRole(Long id);

    ResponseEntity<?> getAllRoles();

    ResponseEntity<?> deleteRole(Long id);

    ResponseEntity<?> update(Long id, RequestNewRole updatedRole);
}