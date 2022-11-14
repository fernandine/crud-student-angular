package com.devsuperior.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.backend.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
