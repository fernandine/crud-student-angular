package com.devsuperior.backend.dto;


import com.devsuperior.backend.entities.Student;

import java.io.Serializable;

public class StudentDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;

    public StudentDto() {
    }

    public StudentDto(Long id, String firstName, String lastName, String gender, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public StudentDto(Student entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        gender = entity.getGender();
        age = entity.getAge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
