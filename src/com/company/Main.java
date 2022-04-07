package com.company;

import com.company.models.Driver;
import com.company.models.Truck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");
    public static final Path WRITE_PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {

        Truck[] trucks = {
                Truck.makeTruck(1, "Chevrolet Colorado", null, State.ON_BASE),
                Truck.makeTruck(2, "Toyota Tundra", null, State.ON_ROUTE),
                Truck.makeTruck(3, "Nissan Frontier", null, State.ON_REPAIR)
        };
        Driver[] drivers = {
                Driver.makeDriver("dr-1", "Sasha", null),
                Driver.makeDriver("dr-2", "Petya", null),
                Driver.makeDriver("dr-3", "Kolya", null)
        };

        String jsonTrucks = GSON.toJson(trucks);
        write(jsonTrucks);
        System.out.println(readFile());
        String jsonDrivers = GSON.toJson(drivers);
        //  System.out.println(json);

        writeDriver(jsonDrivers);
        System.out.println(readFileDriver());

    }

    private static void write(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeDriver(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH1));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile() {
        String json = " ";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String readFileDriver() {
        String json = " ";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH1));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}