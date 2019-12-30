package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Application {

    public static void main(String... args){
        EventHandling eventHandling = new EventHandlingDoorClosedOpenLightOnOff();
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        EventLoop eventLoop = new EventLoop(eventHandling, smartHome);
        eventLoop.startCycle();
    }
}
