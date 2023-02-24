package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.model.UserDTO;
import com.hachaton.onlineshoping.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("list")
    public List<UserDTO> fetchAllUsers() {
        return userService.getAllUser();
    }
}
