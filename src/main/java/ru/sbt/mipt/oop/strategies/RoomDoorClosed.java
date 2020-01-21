package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.*;

public class RoomDoorClosed implements Action<Room> {

    @Override
    public void execute(Room room) {
        SmartHomeObjectIterator<Door> iterator = room.iteratorDoors();
        while (iterator.hasNext()){
            Door door = iterator.getNext();
            door.setOpen(false);
        }
    }

}
