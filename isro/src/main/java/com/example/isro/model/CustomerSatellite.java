package com.example.isro.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Customer_Satellite")
public class CustomerSatellite {

    @Id
    private String id;

    private String country;

    private String launchDate;

    private Double mass;

    private String launcher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getLauncher() {
        return launcher;
    }

    public void setLauncher(String launcher) {
        this.launcher = launcher;
    }

    @Override
    public String toString() {
        return "CustomerSatellite{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", mass=" + mass +
                ", launcher='" + launcher + '\'' +
                '}';
    }
}
