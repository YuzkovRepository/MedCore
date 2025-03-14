package com.example.MedCore.modules.security.repository;

import com.example.MedCore.modules.security.entity.RoleDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleDB, Long> {
    Optional<RoleDB> findById(Long id);
    RoleDB findByRoleName(String roleName);
    List<RoleDB> findByParentRole(RoleDB parentRole);
}
