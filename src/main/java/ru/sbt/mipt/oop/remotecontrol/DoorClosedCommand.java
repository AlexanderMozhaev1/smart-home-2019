package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.Hall;
import ru.sbt.mipt.oop.strategies.RoomDoorClosed;
import ru.sbt.mipt.oop.strategies.RoomLightOn;

public class DoorClosedCommand implements Command{
    SmartHome smartHome;

    public DoorClosedCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        RoomDoorClosed roomDoorClosed = new RoomDoorClosed();
        Hall hall = new Hall(roomDoorClosed);
        smartHome.execute(hall);
    }
}
