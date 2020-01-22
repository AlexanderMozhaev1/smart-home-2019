package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.strategies.DoorClosedOpen;
import ru.sbt.mipt.oop.strategies.Rooms;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class EventSmartHomeDoorClosed implements EventSmartHome {
    @Override
    public boolean eventRun(String objectId, SmartHome smartHome, SensorEventType type) {
        if(type != DOOR_CLOSED) return false;
        DoorClosedOpen doorClosedOpen = new DoorClosedOpen(objectId, false, smartHome);
        Rooms rooms = new Rooms(doorClosedOpen);
        smartHome.execute(rooms);
        return true;
    }
}
