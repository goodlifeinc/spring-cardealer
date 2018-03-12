package com.softuni.springmvc.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    private Integer id;
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<Part> parts;
    private Set<Sale> sales;

    public Car() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "parts_cars",
            joinColumns = { @JoinColumn(name = "car_id" )},
            inverseJoinColumns = { @JoinColumn(name = "part_id" )}
    )
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @OneToMany(mappedBy = "car")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
