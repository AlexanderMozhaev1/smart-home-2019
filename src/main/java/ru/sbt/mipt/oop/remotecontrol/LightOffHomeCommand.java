package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.RoomLightoff;
import ru.sbt.mipt.oop.strategies.Rooms;

public class LightOffHomeCommand implements Command {
    SmartHome smartHome;

    public LightOffHomeCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        RoomLightoff roomLightoff = new RoomLightoff();
        Rooms rooms = new Rooms(roomLightoff);
        smartHome.execute(rooms);
    }
}
