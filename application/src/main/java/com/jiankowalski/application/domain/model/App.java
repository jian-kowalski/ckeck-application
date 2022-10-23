package com.jiankowalski.application.domain.model;


import jakarta.persistence.*;


import java.util.UUID;

@Entity(name = "ttr_app")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;
    private String name;
    private String address;

    public Application(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void update(Application app) {
        this.name = app.getName();
        this.address = app.getAddress();
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
