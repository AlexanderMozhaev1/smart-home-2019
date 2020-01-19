package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public class EventLoop {
    EventHandling eventHandling;
    SmartHome smartHome;

    public EventLoop(EventHandling eventHandling, SmartHome smartHome) {
        this.eventHandling = eventHandling;
        this.smartHome = smartHome;
    }

    public void startCycle(EventSmartHome chain[]) {
        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        while (event != null){
            this.eventHandling.produceEvent(event, this.smartHome, chain);
            event = getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
