package com.ats.model;

public class AirportDTO {
    private String id;
    private String airportName;
    private String city;
    private String country;
    private String countryCode;
    public AirportDTO(){

    }
    public AirportDTO(String id,String airportName,String city,String country,String countryCode){
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
