package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.RequestNewUser;
import com.hachaton.onlineshoping.model.UserDTO;
import com.hachaton.onlineshoping.repository.UserRepository;
import com.hachaton.onlineshoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDTO register(RequestNewUser user) {
        return null;
    }

    @Override
    public UserDTO getUser(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new).toModel();
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(User::toModel).collect(Collectors.toList());
    }

    @Override
    public UserDTO deleteUser(Long id) {
        return null;
    }

    @Override
    public UserDTO update(Long id, RequestNewUser updatedUser) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }
}
