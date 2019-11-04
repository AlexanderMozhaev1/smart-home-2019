package ru.sbt.mipt.oop;

import org.junit.Assert;

import java.util.Collection;
import java.util.List;

public class EventDoorClosedTest {

    @org.junit.Test
    public void DoorOpenRunClosed() {
        Collection<Light> lights = List.of(new Light("light1",false));
        Collection<Door> doors = List.of(new Door(true, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        EventDoorClosed eventDoorClosed = new EventDoorClosed();
        eventDoorClosed.eventRun("door1",smartHome);

        boolean expected = ((Door)((Room)smartHome.getRooms().toArray()[0]).getDoors().toArray()[0]).getOpen();

        Assert.assertEquals(expected, false);
    }
    @org.junit.Test
    public void DoorClosedRunClosed() {
        Collection<Light> lights = List.of(new Light("light1",false));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        EventDoorClosed eventDoorClosed = new EventDoorClosed();
        eventDoorClosed.eventRun("door1",smartHome);

        boolean expected = ((Door)((Room)smartHome.getRooms().toArray()[0]).getDoors().toArray()[0]).getOpen();

        Assert.assertEquals(expected, false);
    }
}