package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmActivate;
import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmDeactivate;

public class Application {

    public static void main(String... args){
        EventSmartHome chain[] = {new EventSmartHomeDoorClosed(), new EventSmartHomeDoorOpen(),
                new EventSmartHomeLightOn(), new EventSmartHomeLightOff(),
                new EventSmartHomeAlarmActivate(), new EventSmartHomeAlarmDeactivate()};
        EventHandling eventHandling = new EventHandlingDoorLightAlarm();
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        EventLoop eventLoop = new EventLoop(eventHandling, smartHome);
        eventLoop.startCycle(chain);
    }
}
