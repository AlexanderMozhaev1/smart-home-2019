package ru.sbt.mipt.oop.Door;

import ru.sbt.mipt.oop.Event;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorCommand;
import ru.sbt.mipt.oop.SmartHome;

public class EventDoorOpen implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        smartHome.iteratorRoom(r->r.iteratorDoors(d -> {
            if (d.getId().equals(objectId)) {
                openDoor(r, d);
            }
        }));
    }

    private void openDoor(Room room, Door door) {
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was open.");
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
