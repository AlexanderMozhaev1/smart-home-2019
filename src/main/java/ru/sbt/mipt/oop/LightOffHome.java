package ru.sbt.mipt.oop;

public class LightOffHome{
    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public void offLightHome(SmartHome smartHome){
        smartHome.iteratorRoom(r -> r.iteratorLights(l -> turnOffLights(l)));
    }

    private void turnOffLights(Light light) {
        light.setOn(false);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        sendCommand(command);
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}