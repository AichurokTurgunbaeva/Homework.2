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
import java.sql.Driver;

public class Truck {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");
    private int id;
    private String name;
    private Driver driver;
    private State state;

    public Truck(int id, String name, Driver driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void  setDriver(Driver driver) {
        this.driver = driver;
    }

        public static State getState() {
        return getState();
    }

    public void setState(State state) {
        this.state = state;
    }
    public static void  makeTruck() {
        Truck[] trucks = {
                new Truck(1, "Chevrolet", null, State.ON_BASE),
                new Truck(2, "Toyota ", null, State.ON_ROUTE),
                new Truck(3, "Nissan ", null, State.ON_REPAIR)
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

    @Override
    public String toString() {
        return
                " " + id +
                        " | " + name +
                        "   |    " + driver +
                        "      |  " + state;
    }
}
