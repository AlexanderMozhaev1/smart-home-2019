package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.strategies.LightOnOff;
import ru.sbt.mipt.oop.strategies.Rooms;

public class EventSmartHomeLightOff implements EventSmartHome {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        LightOnOff lightOnOff = new LightOnOff(objectId, false);
        Rooms rooms = new Rooms(lightOnOff);
        smartHome.execute(rooms);
    }
}
