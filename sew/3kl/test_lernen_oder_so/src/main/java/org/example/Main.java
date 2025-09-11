package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Thing thing = new Thing("frage","antwort",false,69,187);
        System.out.println(thing.toString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("a.json")) {
            gson.toJson(thing, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader= new FileReader("a.json")) {
            System.out.println(gson.fromJson(reader, Thing.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}