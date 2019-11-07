package ru.sbt.mipt.oop.Door;

import ru.sbt.mipt.oop.*;

public class EventDoorClosed implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        smartHome.iteratorRoom(r->r.iteratorDoors(d -> {
            if (d.getId().equals(objectId)) {
                closedDoor(smartHome, r, d);
            }
        }));
    }

    private void closedDoor(SmartHome smartHome, Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
        if (room.getName().equals("hall")) {
            LightOffHome lightOffHome = new LightOffHome();
            lightOffHome.offLightHome(smartHome);
        }
    }


    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
