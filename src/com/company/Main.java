package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");

    public static void main(String[] args) {

        Truck[] trucks = {
                Truck.makeTruck(1, "Chevrolet Colorado", null, State.ON_BASE),
                Truck.makeTruck(2, "Toyota Tundra", null, State.ON_ROUTE),
                Truck.makeTruck(3, "Nissan Frontier", null, State.ON_REPAIR)

        };
        String json = GSON.toJson(trucks);
        //  System.out.println(json);
        write(json);

    }

    private static void write(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}