package com.example.dto;

import com.example.model.Gender;

public class ProductDto {
    private Long id;
    private String name;
    private String color;
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender.value;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
