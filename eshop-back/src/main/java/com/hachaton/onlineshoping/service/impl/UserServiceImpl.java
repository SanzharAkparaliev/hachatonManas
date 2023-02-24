package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Role;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.RequestNewUser;
import com.hachaton.onlineshoping.model.UserDTO;
import com.hachaton.onlineshoping.repository.RoleRepository;
import com.hachaton.onlineshoping.repository.UserRepository;
import com.hachaton.onlineshoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(RequestNewUser user) {
        User newUser = new User();
        Role role = roleRepository.findById(user.getRole()).orElseThrow(NoSuchElementException::new);
        newUser.setUsername(user.getUsername());
        newUser.setRole(role);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser).toModel();
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
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User by id:" + id + " cannot be found !"));
        return user.toModel();
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
