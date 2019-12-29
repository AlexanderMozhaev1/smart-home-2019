package ru.sbt.mipt.oop;

public class EventDoorClosed implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    closedDoor(smartHome, room, door);
                }
            }
        }
    }

    private void closedDoor(SmartHome smartHome, Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
        if (room.getName().equals("hall")) {
            LightOffHome lightOffHome = new LightOffHome();
            lightOffHome.offLightHome(room, smartHome);
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
