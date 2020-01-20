package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EventLoop {
    EventHandling eventHandling;
    SmartHome smartHome;
    ArrayList<SensorEvent> sensorEventList;

    public EventLoop(EventHandling eventHandling, SmartHome smartHome, ArrayList<SensorEvent> sensorEventList) {
        this.eventHandling = eventHandling;
        this.smartHome = smartHome;
        this.sensorEventList = sensorEventList;
    }

    public void startCycle(EventSmartHome chain[]) {
        sensorEventList.forEach(sensorEvent -> this.eventHandling.produceEvent(sensorEvent, this.smartHome, chain));
    }
}
