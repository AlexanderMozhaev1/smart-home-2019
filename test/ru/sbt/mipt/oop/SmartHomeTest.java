package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class SmartHomeTest {

    @Test
    public void iteratorRoom() {
        Collection<Light> lights = List.of(new Light("light1",true));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"),new Room(lights, doors, "room2"),
                new Room(lights, doors, "room3"),new Room(lights, doors, "room4"));
        SmartHome smartHome = new SmartHome(rooms);

        Collection<Room> expected = new ArrayList<>();
        Collection<Room> actual = new ArrayList<>();
        smartHome.iteratorRoom(r -> expected.add(r));
        smartHome.getRooms().forEach(r -> actual.add(r));
        Assert.assertEquals(expected, actual);
    }
}