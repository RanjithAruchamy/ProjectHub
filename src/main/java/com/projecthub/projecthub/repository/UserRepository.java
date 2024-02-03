package com.projecthub.projecthub.repository;

import com.projecthub.projecthub.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
