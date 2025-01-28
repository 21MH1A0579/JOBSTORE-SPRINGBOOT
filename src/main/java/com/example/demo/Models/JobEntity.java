package com.example.demo.Models;

import java.util.Arrays;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "jobstable")
public class JobEntity {

    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
        name = "custom-id-generator",
        strategy = "com.example.demo.IdGenerators.PostIdGenerator")
    private String id;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "experience")
    private int experience;

    @Column(name = "profile", length = 50)
    private String profile;

    @Column(name = "techs", columnDefinition = "TEXT")
    private String techs;

    // Transient field to represent the list of techs
    @Transient
    private List<String> techsList;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for experience
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Getter and Setter for profile
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    // Getter and Setter for techs
    public String getTechs() {
        return techs;
    }

    public void setTechs(String techs) {
        this.techs = techs;
        // Automatically update techsList when techs is set
        this.techsList = Arrays.asList(techs.split(","));
    }

    // Getter for techsList
    public List<String> getTechsList() {
        if (this.techs != null && this.techsList == null) {
            this.techsList = Arrays.asList(this.techs.split(","));
        }
        return this.techsList;
    }

    // Setter for techsList
    public void setTechsList(List<String> techsList) {
        this.techsList = techsList;
        // Automatically update techs when techsList is set
        this.techs = String.join(",", techsList);
    }
}
