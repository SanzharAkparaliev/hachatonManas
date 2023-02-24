package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.RequestNewUser;
import com.hachaton.onlineshoping.model.UserDTO;

public interface UserService {
    UserDTO register(RequestNewUser user);

    UserDTO getUser(Long id);

    UserDTO getAllUser();

    UserDTO deleteUser(Long id);

    UserDTO update(Long id, RequestNewUser updatedUser);

    User getCurrentUser();
}
