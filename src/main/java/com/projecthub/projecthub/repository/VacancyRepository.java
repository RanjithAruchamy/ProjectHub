package com.projecthub.projecthub.repository;

import com.projecthub.projecthub.entities.Projects;
import com.projecthub.projecthub.entities.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancies, Long> {

}
