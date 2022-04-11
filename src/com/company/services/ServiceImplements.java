package com.company.services;

import com.company.State;
import com.company.models.Driver;
import com.company.models.Truck;

import java.util.Random;

public class ServiceImplements implements Service{
    public void changeDriver(Truck truck, Driver driver) {
        if (Truck.getState().equals(State.ON_BASE)) {
            truck.setDriver((java.sql.Driver) driver.getDriver());
            driver.setBus(Truck.getName());
        } else if (Truck.getState().equals(State.ON_ROUTE)) {
            System.out.println("Driver is already on the route!");
        } else {
            System.out.println("You can't change the driver!");
        }
    }
    @Override
    public void startDriving(Truck truck, Driver driver) {
        if (Truck.getState().equals(State.ON_BASE)) {
            if (truck.getDriver() != null) {
                truck.setState(State.ON_ROUTE);
                System.out.println("Driver started his way successfully!");
            } else {
                System.out.println("There is no driver!");
            }
        } else if (Truck.getState().equals(State.ON_ROUTE)) {
            System.out.println("Driver is already on the route!");
        } else {
            Random random = new Random();
            int rnd = random.nextInt(2);
            if (rnd == 0) {
                truck.setState(State.ON_ROUTE);
                System.out.println("Truck is on the route!");
            } else {
                truck.setState(State.ON_BASE);
                System.out.println("Truck is on the base!");
            }
        }
    }


    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (Truck.getState().equals(State.ON_BASE)) {
            truck.setState(State.ON_REPAIR);
            System.out.println("Truck is on repairing now!");
        } else if (Truck.getState().equals(State.ON_ROUTE)) {
            truck.setState(State.ON_REPAIR);
        } else {
            System.out.println("Truck is already on repair!");
        }
    }
}

