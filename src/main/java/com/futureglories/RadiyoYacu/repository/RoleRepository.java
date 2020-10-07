package com.futureglories.RadiyoYacu.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.futureglories.RadiyoYacu.model.ERole;
import com.futureglories.RadiyoYacu.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}