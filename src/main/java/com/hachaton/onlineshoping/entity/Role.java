package com.hachaton.onlineshoping.entity;

import com.hachaton.onlineshoping.model.RoleDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
@SequenceGenerator(name = "SEQ_ID", sequenceName = "ROLE_SEQ", allocationSize = 1, initialValue = 10)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    private Long id;

    @Column(name = "role_name")
    private String roleName;



    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "role_has_permissions",
            joinColumns = {@JoinColumn(name = "id_role")},
            inverseJoinColumns = {@JoinColumn(name = "id_permission")})
    private Set<Permission> permissions;


    public RoleDTO toModel() {
        return RoleDTO.builder()
                .id(id)
                .roleName(roleName)
                .permissions(permissions.stream().map(Permission::toModel).collect(Collectors.toSet()))
                .build();
    }

}
