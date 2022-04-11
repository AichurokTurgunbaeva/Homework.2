package com.company.services;

import com.company.models.Driver;
import com.company.models.Truck;

public interface Service {

    void changeDriver(Truck truck, Driver driver);
    void startDriving(Truck truck,Driver driver);

    void startRepair(Truck truck, Driver driver);
}
