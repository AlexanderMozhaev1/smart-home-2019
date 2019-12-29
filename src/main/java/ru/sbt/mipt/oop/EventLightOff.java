package ru.sbt.mipt.oop;

public class EventLightOff implements Event{
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(objectId)) {
                    turnOffLights(room, light);
                }
            }
        }
    }

    private void turnOffLights(Room room, Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
    }
}
