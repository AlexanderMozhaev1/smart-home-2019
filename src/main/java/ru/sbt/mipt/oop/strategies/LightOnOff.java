package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.*;

public class LightOnOff implements Action<Room> {
    String objectId;
    boolean isOn;

    public LightOnOff(String objectId, boolean isOn) {
        this.objectId = objectId;
        this.isOn = isOn;
    }

    @Override
    public void execute(Room room) {
        SmartHomeObjectIterator<Light> iterator = room.iteratorLights();
        while (iterator.hasNext()){
            Light light = iterator.getNext();
            if(light.getId().equals(objectId)) {
                if (isOn) {
                    turnOnLights(room, light);
                } else {
                    turnOffLights(room, light);
                }
            }
        }
    }

    private void turnOffLights(Room room, Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
    }

    private void turnOnLights(Room room, Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
    }
}
