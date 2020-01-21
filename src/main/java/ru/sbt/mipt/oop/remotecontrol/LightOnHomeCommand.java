package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.RoomLightOn;
import ru.sbt.mipt.oop.strategies.RoomLightoff;
import ru.sbt.mipt.oop.strategies.Rooms;

public class LightOnHomeCommand implements Command {
    SmartHome smartHome;

    public LightOnHomeCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        RoomLightOn roomLightOn = new RoomLightOn();
        Rooms rooms = new Rooms(roomLightOn);
        smartHome.execute(rooms);
    }
}