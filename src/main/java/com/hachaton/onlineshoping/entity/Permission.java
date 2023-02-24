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
@SequenceGenerator(name = "SEQ_ID", sequenceName = "USER_PERMISSION_SEQ", allocationSize = 1, initialValue = 10)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PERMISSION_SEQ")
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE, mappedBy = "permissions")
    private Set<Role> roles;

    public PermissionDTO toModel() {
        return PermissionDTO.builder()
                .id(id)
                .permissionName(permissionName)
                .build();
    }
}
