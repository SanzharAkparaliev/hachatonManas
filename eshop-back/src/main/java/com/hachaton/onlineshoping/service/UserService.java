package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.RequestNewUser;
import com.hachaton.onlineshoping.model.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity register(RequestNewUser user);

    UserDTO getUser(Long id);

     List<UserDTO> getAllUser();

    UserDTO deleteUser(Long id);

    UserDTO update(Long id, RequestNewUser updatedUser);

    User getCurrentUser();
}
