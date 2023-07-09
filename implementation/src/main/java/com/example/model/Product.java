package com.example.model;


import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String color;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
