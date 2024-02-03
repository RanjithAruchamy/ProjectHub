package com.projecthub.projecthub.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Vacancies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String position;

    private int count;

    @JoinColumn(name = "projectId")
    @ManyToOne()
    @JsonIgnore
    private Projects projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
}
