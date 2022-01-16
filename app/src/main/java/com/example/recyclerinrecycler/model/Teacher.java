package com.example.recyclerinrecycler.model;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private String subject;
    private Boolean isProfessor;
    private Integer profile;
    private ArrayList<Students> students;

    public Teacher(String name, String subject, Boolean isProfessor, Integer profile, ArrayList<Students> students) {
        this.name = name;
        this.subject = subject;
        this.isProfessor = isProfessor;
        this.profile = profile;
        this.students = students;
    }

    public Teacher() {

    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getProfessor() {
        return isProfessor;
    }

    public void setProfessor(Boolean professor) {
        isProfessor = professor;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }
}

