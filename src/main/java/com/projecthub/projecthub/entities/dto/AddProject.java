package com.projecthub.projecthub.entities.dto;

import java.util.List;

public class AddProject {

    private String name;

    private String description;

    private List<VacancyDto> vacancies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VacancyDto> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<VacancyDto> vacancies) {
        this.vacancies = vacancies;
    }
}
