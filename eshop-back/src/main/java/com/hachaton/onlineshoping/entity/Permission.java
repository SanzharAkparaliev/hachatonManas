package com.hachaton.onlineshoping.entity;


import com.hachaton.onlineshoping.model.PermissionDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PERMISSIONS")
@SequenceGenerator(name = "id_generator", sequenceName = "PERMISSION_SEQ", allocationSize = 1)
public class Permission extends BaseEntity {

    @Column(name = "permission_name")
    private String permissionName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy = "permissions")
    private Set<Role> roles;

    public PermissionDTO toModel() {
        return PermissionDTO.builder()
                .id(id)
                .permissionName(permissionName)
                .build();
    }
}
