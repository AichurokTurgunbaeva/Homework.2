package com.company.models;
import com.company.State;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Truck {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");
    private int id;
    private String name;
    private String driver;
    private State state;

    public Truck(int id, String name, String driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public Truck() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void  setDriver(String driver) {
        this.driver = driver;
    }

        public  State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public static void  makeTruck() {
        Truck[] trucks = {
                new Truck(1, "Chevrolet", null, State.ON_BASE),
                new Truck(2, "Toyota ", null, State.ON_BASE),
                new Truck(3, "Nissan ", null, State.ON_BASE)
        };
        Gson gson = new Gson();
        String json = GSON.toJson(trucks);
        System.out.println(readTruckFile());
        writeTruckFile(json);

        Truck[] truck = GSON.fromJson(readTruckFile(), Truck[].class);
        for (Truck truck1 : truck) {
            System.out.println(truck1.toString());
        }
    }

    public static void writeTruckFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTruckFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
            return json;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return json;
    }
    public void changeDriver(Truck truck, com.company.models.Driver driver) {
        if (truck.getState().equals(State.ON_BASE)) {
            truck.setDriver(driver.getDriver());
            driver.setBus(truck.getName());
        } else if (truck.getState().equals(State.ON_ROUTE)) {
            System.out.println("Driver is already on the route!");
        } else {
            System.out.println("You can't change the driver!");
        }
    }
    public void startDriving(Truck truck, com.company.models.Driver driver) {
        if (truck.getState().equals(State.ON_BASE)) {
            if (truck.getDriver() != null) {
                truck.setState(State.ON_ROUTE);
                System.out.println("Driver started his way successfully!");
            } else {
                System.out.println("There is no driver!");
            }
        } else if (truck.getState().equals(State.ON_ROUTE)) {
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

    public void startRepair(Truck truck, Driver driver) {
        if (truck.getState().equals(State.ON_BASE)) {
            truck.setState(State.ON_REPAIR);
            System.out.println("Truck is on repairing now!");
        } else if (truck.getState().equals(State.ON_ROUTE)) {
            truck.setState(State.ON_REPAIR);
        } else {
            System.out.println("Truck is already on repair!");
        }
    }

    @Override
    public String toString() {
        return
                " " + id +
                        " | " + name +
                        "   |    " + driver +
                        "      |  " + state;
    }
}
