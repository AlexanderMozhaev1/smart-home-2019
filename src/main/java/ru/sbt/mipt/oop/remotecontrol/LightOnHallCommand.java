package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.Hall;
import ru.sbt.mipt.oop.strategies.RoomLightOn;
import ru.sbt.mipt.oop.strategies.Rooms;

public class LightOnHallCommand  implements Command {
    SmartHome smartHome;

    public LightOnHallCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        RoomLightOn roomLightoff = new RoomLightOn();
        Hall hall = new Hall(roomLightoff);
        smartHome.execute(hall);
    }
}