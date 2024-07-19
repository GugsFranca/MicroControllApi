package com.micro.usersapi.repository;

import com.micro.usersapi.model.RoleModel;
import com.micro.usersapi.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
    RoleModel findByRoleName(RoleName roleName);
}
