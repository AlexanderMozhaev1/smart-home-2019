package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public class Room  implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public SmartHomeObjectIterator iteratorLights(){
        return new SmartHomeObjectIterator((ArrayList) lights);
    }

    public SmartHomeObjectIterator iteratorDoors(){
        return new SmartHomeObjectIterator((ArrayList) doors);
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
