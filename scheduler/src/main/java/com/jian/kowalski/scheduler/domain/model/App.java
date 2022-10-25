package com.jian.kowalski.scheduler.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class App {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;

    protected App() {
        //For JPA/Hibernate
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
