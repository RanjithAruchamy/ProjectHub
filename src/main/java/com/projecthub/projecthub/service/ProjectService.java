package com.projecthub.projecthub.service;

import com.projecthub.projecthub.entities.Projects;
import com.projecthub.projecthub.entities.UserEntity;
import com.projecthub.projecthub.entities.Vacancies;
import com.projecthub.projecthub.entities.dto.AddProject;
import com.projecthub.projecthub.repository.ProjectRepository;
import com.projecthub.projecthub.repository.UserRepository;
import com.projecthub.projecthub.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    public Projects getProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Projects addProject(AddProject projects) {
        var project = new Projects();
        project.setName(projects.getName());
        project.setDescription(projects.getDescription());
        projectRepository.save(project);

        return project;
    }

    public Projects addUser(Long projectId, Long userId, Vacancies vacancies) throws IOException {
        var project = projectRepository.findById(projectId).orElse(null);
        var user = userRepository.findById(userId).orElse(null);
        var vacancy = vacancyRepository.findById(vacancies.getId()).orElse(null);
        if (user != null && project != null) {
            if (project.equals(user.getProjects())) {
                throw new IOException("User already linked with this project");
            }
            user.setProjects(project);
            userRepository.save(user);
        }
        if (project != null) {
            project.setAvailableCount(project.getAvailableCount() - 1);
            projectRepository.save(project);
        }
        if (vacancy != null) {
            vacancy.setCount(vacancy.getCount() - 1);
            vacancyRepository.save(vacancy);
        }
        return project;
    }
}
