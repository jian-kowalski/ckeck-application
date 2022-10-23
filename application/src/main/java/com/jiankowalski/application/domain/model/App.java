package com.jiankowalski.application.domain.model;


import jakarta.persistence.*;


import java.util.UUID;

@Entity(name = "ttr_app")
public class App {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;

    protected App(){

    }

    public App(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
