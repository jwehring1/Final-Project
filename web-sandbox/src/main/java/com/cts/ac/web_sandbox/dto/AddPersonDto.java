package com.cts.ac.web_sandbox.dto;

public class AddPersonDto {
    private String name;
    private int age;
    private int ssn;
    private String race;
    private int height;
    private double weight;
    private String street;

    public AddPersonDto()
    {
        name = "Unknown";
        age = -1;
        ssn = -1;
        race = "Unknown";
        height = -1;
        weight = -1;
        street = "Unknown";
    }

    public AddPersonDto(String name, int age, int ssn, String race, int height, double weight, String street)
    {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
