package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.strategies.LightOnOff;
import ru.sbt.mipt.oop.strategies.Rooms;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class EventSmartHomeLightOff implements EventSmartHome {
    @Override
    public boolean eventRun(String objectId, SmartHome smartHome, SensorEventType type) {
        if(type != DOOR_CLOSED) return false;
        LightOnOff lightOnOff = new LightOnOff(objectId, false);
        Rooms rooms = new Rooms(lightOnOff);
        smartHome.execute(rooms);
        return true;
    }
}
