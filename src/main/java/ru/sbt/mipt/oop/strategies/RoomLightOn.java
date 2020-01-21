package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.*;

public class RoomLightOn implements Action<Room> {

    @Override
    public void execute(Room room) {
        SmartHomeObjectIterator<Light> iterator = room.iteratorLights();
        while (iterator.hasNext()){
            Light light = iterator.getNext();
            light.setOn(true);
        }
    }
}