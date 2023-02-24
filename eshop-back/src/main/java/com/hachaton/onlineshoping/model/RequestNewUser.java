package com.hachaton.onlineshoping.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestNewUser {

    String username;
    String password;
    Long role;
}