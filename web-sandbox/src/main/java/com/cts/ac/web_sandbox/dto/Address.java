package com.cts.ac.web_sandbox.dto;

public class Address {
    private int AddressId;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    public Address()
    {
        AddressId = -1;
        street = "Unknown";
        city = "Unknown";
        state = "Unknown";
        zipcode = 00000;
    }

    public Address(String street, String city, String state, int zipcode)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public int getAddressId() {return AddressId;}

    public void setAddressId(int AddressId) {this.AddressId = AddressId;}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "[" +
                "street: " + street +
                ", city: " + city +
                ", state: " + state +
                ", zipcode: " + zipcode +
                ']';
    }
}
