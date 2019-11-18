package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        EventHandling eventHandling = new EventHandlingDoorLightAlarm();
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        // считываем состояние дома из файла
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        // запускаем API для работы с сенсорами
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventHandlerAdapter(smartHome));
        sensorEventsManager.start();
    }
}
