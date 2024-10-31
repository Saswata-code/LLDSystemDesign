package com.example.isro.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rockets")
public class Rocket {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private RocketType rocketType;

    private Date registeredDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RocketType getRocketType() {
        return rocketType;
    }

    public void setRocketType(RocketType rocketType) {
        this.rocketType = rocketType;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
