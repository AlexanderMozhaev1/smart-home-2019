package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class EventLightOnTest {

    @Test
    public void LightOffRunOn() {
        Collection<Light> lights = List.of(new Light("light1",false));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        EventLightOn eventLightOn = new EventLightOn();
        eventLightOn.eventRun("light1",smartHome);

        boolean expected = ((Light)((Room)smartHome.getRooms().toArray()[0]).getLights().toArray()[0]).isOn();

        Assert.assertEquals(expected, true);
    }
    @Test
    public void LightOnRunOn() {
        Collection<Light> lights = List.of(new Light("light1",true));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        EventLightOn eventLightOn = new EventLightOn();
        eventLightOn.eventRun("light1",smartHome);

        boolean expected = ((Light)((Room)smartHome.getRooms().toArray()[0]).getLights().toArray()[0]).isOn();

        Assert.assertEquals(expected, true);
    }
}