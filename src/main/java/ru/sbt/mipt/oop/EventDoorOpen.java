package ru.sbt.mipt.oop;

public class EventDoorOpen implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    openDoor(room, door);
                }
            }
        }
    }

    private void openDoor(Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was open.");
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
