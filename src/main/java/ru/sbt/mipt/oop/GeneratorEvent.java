package ru.sbt.mipt.oop;

import java.util.*;

public class GeneratorEvent {
    public static ArrayList<SensorEvent> generait(){
        ArrayList<SensorEvent> sensorEventList = new ArrayList<>();
        SensorEvent event = getNextSensorEvent();
        while (event != null){
            sensorEventList.add(event);
            event = getNextSensorEvent();
        }
        return  sensorEventList;
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
