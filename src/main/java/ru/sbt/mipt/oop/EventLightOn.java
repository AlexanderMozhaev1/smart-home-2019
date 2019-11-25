package ru.sbt.mipt.oop;

public class EventLightOn implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        smartHome.iteratorRoom(r-> r.iteratorLights(l -> {
            if (l.getId().equals(objectId)) {
                turnOnLights(r, l);
            }
        }));
    }

    private void turnOnLights(Room room, Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
    }
}
