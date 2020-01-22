package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.LightOffHome;

public class DoorClosedOpen implements Action<Room> {
    private String objectId;
    private boolean isOpen;
    private SmartHome smartHome;

    public DoorClosedOpen(String objectId, boolean isOpen, SmartHome smartHome) {
        this.objectId = objectId;
        this.isOpen = isOpen;
        this.smartHome = smartHome;
    }

    @Override
    public void execute(Room room) {
        SmartHomeObjectIterator<Door> iterator = room.iteratorDoors();
        while (iterator.hasNext()){
            Door door = iterator.getNext();
            if(door.getId().equals(objectId)) {
                if (isOpen) {
                    openDoor(room, door);
                } else {
                    closedDoor(room, door);
                }
            }
        }
    }

    private void closedDoor(Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
        if (room.getName().equals("hall")) {
            LightOffHome lightOffHome = new LightOffHome();
            lightOffHome.offLightHome(this.smartHome);
        }
    }
    private void openDoor(Room room, Door door) {
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was open.");
    }
}
