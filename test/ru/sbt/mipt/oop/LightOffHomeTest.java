package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class LightOffHomeTest {

    @Test
    public void offLightHome() {
        Collection<Light> lights1 = List.of(new Light("light1",false)
                ,new Light("light2",false),new Light("light3",false));
        Collection<Light> lights2 = List.of(new Light("light4",true)
                ,new Light("light5",false),new Light("light6",true));
        Collection<Door> doors = List.of(new Door(false, "door1"));
        Collection<Room> rooms = List.of(new Room(lights1, doors, "room1"),
                new Room(lights2, doors, "room1"));
        SmartHome smartHome = new SmartHome(rooms);

        LightOffHome lightOffHome = new  LightOffHome();
        lightOffHome.offLightHome(smartHome);

        smartHome.iteratorRoom(r->r.iteratorLights(l-> Assert.assertEquals(l.isOn(), false)));
    }
}