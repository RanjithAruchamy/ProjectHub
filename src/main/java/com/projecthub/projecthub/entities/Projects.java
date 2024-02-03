package com.projecthub.projecthub.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private int availableCount;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "projects"
    )
    private List<Vacancies> vacancies;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "projects"
    )
    private List<UserEntity> resources;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public List<Vacancies> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancies> vacancies) {
        this.vacancies = vacancies;
    }

    public List<UserEntity> getResources() {
        return resources;
    }

    public void setResources(List<UserEntity> resources) {
        this.resources = resources;
    }
}
