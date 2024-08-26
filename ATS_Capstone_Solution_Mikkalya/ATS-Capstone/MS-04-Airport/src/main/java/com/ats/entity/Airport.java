package com.ats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {
    @Id
    private String id;
    @Column(name="Airport_Name",nullable = false)
    private String airportName;
    @Column(name="City",nullable = false)
    private String city;
    @Column(name="Country",nullable = false)
    private String country;
    @Column(name="Country_Code",nullable = false)
    private String countryCode;
    public Airport(){

    }
    public Airport(String id,String airportName,String city,String country,String countryCode){
        this.id=id;
        this.airportName=airportName;
        this.city=city;
        this.country=country;
        this.countryCode=countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
