package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        EventHandling eventHandling = new EventHandlingDoorClosedOpenLightOnOff();
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        EventLoop eventLoop = new EventLoop(eventHandling, smartHome);
        eventLoop.startCycle();
    }
}
