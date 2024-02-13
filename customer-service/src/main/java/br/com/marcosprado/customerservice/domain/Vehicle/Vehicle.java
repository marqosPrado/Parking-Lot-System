package br.com.marcosprado.customerservice.domain.Vehicle;

import br.com.marcosprado.customerservice.domain.Customer.Customer;
import br.com.marcosprado.customerservice.enums.VehicleType;
import jakarta.persistence.*;

import java.time.Year;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Customer customerId;
    private VehicleType type;
    private String brand;
    private String model;
    private Year year;
    private String color;
    private String licensePlate;

    public Vehicle() {}

    public Vehicle(Customer customerId,
                   VehicleType type,
                   String brand,
                   String model,
                   Year year,
                   String color,
                   String licensePlate) {
        this.customerId = customerId;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
