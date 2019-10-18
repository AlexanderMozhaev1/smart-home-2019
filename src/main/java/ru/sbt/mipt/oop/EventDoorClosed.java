package ru.sbt.mipt.oop;

public class EventDoorClosed implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                    LightOffHome lightOffHome = new LightOffHome();
                    lightOffHome.offLightHome(room, smartHome);
                }
            }
        }
    }
    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
