package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;

public class Hall implements Action<SmartHome> {
    Action action;

    public Hall(Action action) {
        this.action = action;
    }

    @Override
    public void execute(SmartHome smartHome) { smartHome.getRooms().forEach(r -> {
            if(r.getName().equals("hall")) r.execute(action);
    });
    }
}
