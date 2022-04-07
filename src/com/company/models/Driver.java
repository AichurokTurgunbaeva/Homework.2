package com.company.models;

import com.company.State;

public class Driver {
    private String id;
    private String name;
    private Truck truck;

    public Driver() {
    }

    public Driver(String id, String name, Truck truck) {
        this.id = id;
        this.name = name;
        this.truck = truck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public static Driver makeDriver(String id, String name, Truck truck) {
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truck = truck;
        return driver;
    }

    @Override
    public String toString() {
        return "Driver's info - " +
                "id: " + id +
                ", name: " + name + '\'' +
                ", truck: " + truck +
                '}';
    }
}