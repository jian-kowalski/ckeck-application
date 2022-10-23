package com.jiankowalski.application.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
public class Application {
    @Id
    @GeneratedValue( generator = "uuid2" )
    @GenericGenerator( name = "uuid2", strategy = "uuid2" )

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
