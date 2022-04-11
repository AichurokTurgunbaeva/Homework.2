package com.company;

import com.company.models.Driver;
import com.company.models.Truck;
import com.company.services.ServiceImplements;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {
                new Truck(1, "Chevrolet", null, State.ON_BASE),
                new Truck(2, "Toyota ", null, State.ON_ROUTE),
                new Truck(3, "Nissan ", null, State.ON_REPAIR)
        };

        Driver[] drivers = {
                new Driver("dr-1", "Sasha", null),
                new Driver("dr-2", "Petya", null),
                new Driver("dr-3", "Kolya", null)
        };

        print(trucks);
        print(drivers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Choose one of the trucks: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            ServiceImplements service = new ServiceImplements();
            getInstruction();
            String action = scanner.nextLine();
            switch (action) {
                case "1" -> service.changeDriver(trucks[input - 1], drivers[input - 1]);
                case "2" -> service.startDriving(trucks[input - 1], drivers[input - 1]);
                case "3" -> service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }


    public static void print(Truck[] trucks) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }

    public static void getInstruction() {
        System.out.println("Press to 1 to change driver");
        System.out.println("Press to 2 to start driving");
        System.out.println("Press to 3 to start repair");
    }
}