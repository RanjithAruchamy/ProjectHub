package com.projecthub.projecthub.repository;

import com.projecthub.projecthub.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
}
