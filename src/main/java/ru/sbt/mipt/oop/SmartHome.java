package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class SmartHome {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void iteratorRoom(Consumer <? super Room>consumer){
        rooms.forEach(consumer);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
