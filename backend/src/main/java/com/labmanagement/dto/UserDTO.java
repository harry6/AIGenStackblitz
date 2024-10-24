package com.labmanagement.dto;

import lombok.Data;
import com.labmanagement.entity.User.Role;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Role role;
}