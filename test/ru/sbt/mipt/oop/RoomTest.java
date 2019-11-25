package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void iteratorLights() {
        Collection<Light> lights = List.of(new Light("light1",true),new Light("light2",true),
                new Light("light3",true),new Light("light4",true));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        Collection<Light> expected = new ArrayList<>();
        Collection<Light> actual = new ArrayList<>();
        smartHome.iteratorRoom(r -> r.iteratorLights(l -> expected.add(l)));
        smartHome.getRooms().forEach(r -> r.iteratorLights(l -> actual.add(l)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iteratorDoors() {
        Collection<Light> lights = List.of(new Light("light1",true));
        Collection<Door> doors = List.of(new Door(false, "door1"),new Door(false, "door2"),
                new Door(false, "door3"),new Door(false, "door4"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        Collection<Door> expected = new ArrayList<>();
        Collection<Door> actual = new ArrayList<>();
        smartHome.iteratorRoom(r -> r.iteratorDoors(d -> expected.add(d)));
        smartHome.getRooms().forEach(r -> r.iteratorDoors(d -> actual.add(d)));
        Assert.assertEquals(expected, actual);
    }
}