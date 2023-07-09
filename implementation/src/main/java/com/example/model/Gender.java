package com.example.model;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    UNISEX("UNISEX");

    public final String value;

    Gender(String value) {
        this.value = value;
    }
}
