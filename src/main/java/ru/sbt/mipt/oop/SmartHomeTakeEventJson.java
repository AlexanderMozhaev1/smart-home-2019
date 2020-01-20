package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeTakeEventJson implements SmartHomeTakeEvent {
    String fileName;
    public SmartHomeTakeEventJson(String fileName){
        this.fileName = fileName;
    }
    @Override
    public SmartHome takeSmartHome() {
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, SmartHome.class);
    }
}
