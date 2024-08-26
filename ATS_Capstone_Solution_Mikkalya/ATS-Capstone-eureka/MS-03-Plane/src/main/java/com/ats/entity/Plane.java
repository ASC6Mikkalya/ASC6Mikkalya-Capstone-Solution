package com.ats.entity;


import jakarta.persistence.*;

@Entity
@Table(name="plane")
public class Plane {
    @Id
    private String id;
    @Column(name = "Model",nullable = false)
    private String model;
    @Column(name = "Manufacturer",nullable = false)
    private String manufacturer;
    @Column(name = "Image",nullable = false)
    private String image;
    @Column(name = "Seating_Capacity",nullable = false)
    private int seatingCapacity;
    public Plane(){

    }
    public Plane(String id, String model, String manufacturer,String image, int seatingCapacity){
        this.id=id;
        this.model=model;
        this.manufacturer=manufacturer;
        this.image=image;
        this.seatingCapacity=seatingCapacity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
