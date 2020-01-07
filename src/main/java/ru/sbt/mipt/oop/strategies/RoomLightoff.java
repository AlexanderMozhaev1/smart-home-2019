package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.*;

public class RoomLightoff implements Action<Room> {

    @Override
    public void execute(Room room) {
        SmartHomeObjectIterator<Light> iterator = room.iteratorLights();
        while (iterator.hasNext()){
            Light light = iterator.getNext();
            turnOffLights(light);
        }
    }

    private void turnOffLights(Light light) {
        light.setOn(false);
        commandRun(light);
    }

    private void commandRun(Light light) {
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        sendCommand(command);
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
