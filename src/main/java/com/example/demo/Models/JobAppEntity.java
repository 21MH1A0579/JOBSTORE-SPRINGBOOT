package com.example.demo.Models;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="job_app_table")
public class JobAppEntity {
    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
        name = "custom-id-generator",
        strategy = "com.example.demo.IdGenerators.JobApplicationIdGenerator")
    private String id;
    
    @Column
    private String job_id;
    @Column
    private String user_id;
    @Column
    private String user_name;
    @Column
    private String user_email;
    
    @Column
    private int x_percent;
    @Column
    private int xii_percent;
    @Column
    private int ug_percent;
    @Column
    private String selected_skills;

    @Transient
    private List<String> selectedSkillsList;

    @Column
    private int final_score;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'Pending'")
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getX_percent() {
        return x_percent;
    }

    public void setX_percent(int x_percent) {
        this.x_percent = x_percent;
    }

    public int getXii_percent() {
        return xii_percent;
    }

    public void setXii_percent(int xii_percent) {
        this.xii_percent = xii_percent;
    }

    public int getUg_percent() {
        return ug_percent;
    }

    public void setUg_percent(int ug_percent) {
        this.ug_percent = ug_percent;
    }

    public String getSelected_skills() {
        return selected_skills;
    }

    public void setSelected_skills(String selected_skills) {
        this.selected_skills = selected_skills;
        // Automatically update the list when the string is set
        this.selectedSkillsList = Arrays.stream(selected_skills.split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
    }

    public List<String> getSelectedSkillsList() {
        if (selectedSkillsList == null && selected_skills != null) {
            // Lazily populate the list if it wasn't already set
            selectedSkillsList = Arrays.stream(selected_skills.split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
        }
        return selectedSkillsList;
    }

    public int getFinal_score() {
        return final_score;
    }

    public void setFinal_score(int final_score) {
        this.final_score = final_score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
