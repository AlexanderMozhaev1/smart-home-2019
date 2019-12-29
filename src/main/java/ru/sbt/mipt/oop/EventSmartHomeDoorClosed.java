package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.strategies.DoorClosedOpen;
import ru.sbt.mipt.oop.strategies.Rooms;

public class EventSmartHomeDoorClosed implements EventSmartHome {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        DoorClosedOpen doorClosedOpen = new DoorClosedOpen(objectId, false, smartHome);
        Rooms rooms = new Rooms(doorClosedOpen);
        smartHome.execute(rooms);
    }
}
