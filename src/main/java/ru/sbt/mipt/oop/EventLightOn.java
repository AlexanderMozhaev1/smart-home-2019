package ru.sbt.mipt.oop;

public class EventLightOn implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(objectId)) {
                    light.setOn(true);
                    System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                }
            }
        }
    }
}
