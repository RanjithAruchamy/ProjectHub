package com.projecthub.projecthub.controller;

import com.projecthub.projecthub.entities.Projects;
import com.projecthub.projecthub.entities.UserEntity;
import com.projecthub.projecthub.entities.Vacancies;
import com.projecthub.projecthub.entities.dto.AddProject;
import com.projecthub.projecthub.entities.dto.VacancyDto;
import com.projecthub.projecthub.service.ProjectService;
import com.projecthub.projecthub.service.UserService;
import com.projecthub.projecthub.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Projects>> getAllProjects() {
        var projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping(value = "/{projectId}")
    @ResponseBody
    public ResponseEntity<Projects> getProject(
            @PathVariable Long projectId
    ) {
        var projects = projectService.getProject(projectId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Projects> addUser(
            @RequestBody AddProject projects
    ) {
        var projectResponse = projectService.addProject(projects);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/{projectId}/vacancy", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Vacancies> addVacancy(
            @PathVariable Long projectId,
            @RequestBody VacancyDto vacancyDto
    ) {
        var projectResponse = vacancyService.addVacancy(projectId, vacancyDto);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/{projectId}/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Projects> addUser(
            @PathVariable Long projectId,
            @PathVariable Long userId,
            @RequestBody Vacancies vacancies
    ) throws IOException {
        var projectResponse = projectService.addUser(projectId, userId, vacancies);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }
}
