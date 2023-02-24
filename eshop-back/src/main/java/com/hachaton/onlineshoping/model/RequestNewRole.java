package com.hachaton.onlineshoping.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestNewRole {

    String roleName;
    List<Long> permissions;
}