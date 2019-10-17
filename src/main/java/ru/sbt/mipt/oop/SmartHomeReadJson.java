package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeReadJson implements SmartHomeRead {
    String fileName;
    SmartHomeReadJson(String _fileName){
        fileName = _fileName;
    }
    @Override
    public SmartHome smartHomeReader() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}
