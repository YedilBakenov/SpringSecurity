package com.example.sec.repository;

import com.example.sec.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository <Permission, Integer> {
}
