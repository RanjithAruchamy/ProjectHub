package com.projecthub.projecthub.service;

import com.projecthub.projecthub.entities.Vacancies;
import com.projecthub.projecthub.entities.dto.VacancyDto;
import com.projecthub.projecthub.repository.ProjectRepository;
import com.projecthub.projecthub.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Vacancies addVacancy(Long projectId, VacancyDto vacancyDto) {
        var vacancy = new Vacancies();
        vacancy.setCount(vacancyDto.getCount());
        vacancy.setPosition(vacancyDto.getPosition());
        var project = projectRepository.findById(projectId)
                .orElse(null);

        if (project != null) {
            vacancy.setProjects(project);
            vacancyRepository.save(vacancy);
            project.setAvailableCount(project.getAvailableCount() + vacancy.getCount());
            projectRepository.save(project);
        }
        return vacancy;
    }
}
