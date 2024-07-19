package com.micro.usersapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link UserModel}
 */
public record UserModelDto( String password, @NotBlank String username, List<RoleModel> role) implements Serializable {
}