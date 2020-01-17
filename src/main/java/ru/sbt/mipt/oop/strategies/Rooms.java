package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeObjectIterator;

public class Rooms implements Action<SmartHome> {
    Action action;

    public Rooms(Action action) {
        this.action = action;
    }

    @Override
    public void execute(SmartHome smartHome) { smartHome.getRooms().forEach(r -> r.execute(action)); }

}
