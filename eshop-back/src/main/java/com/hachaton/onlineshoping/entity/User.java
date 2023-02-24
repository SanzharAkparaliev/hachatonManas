package com.hachaton.onlineshoping.entity;

import com.hachaton.onlineshoping.model.RoleDTO;
import com.hachaton.onlineshoping.model.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
@SequenceGenerator(name = "id_generator", sequenceName = "USER_SEQ", allocationSize = 1)
public class User extends BaseEntity{

    @NotBlank
    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_role")
    private Role role;





    public UserDTO toModel() {
        return UserDTO.builder()
                .id(id)
                .role(role == null ? new RoleDTO() : role.toModel())
                .username(username)
                .build();
    }
}
