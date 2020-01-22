package ru.sbt.mipt.oop;

public class EventHandlingDoorLightAlarm implements EventHandling {
    @Override
    public void produceEvent(SensorEvent event, SmartHome smartHome, EventSmartHome chain[]) {
        if(event != null) {
            SensorEventType type = event.getType();
            System.out.println("Got event: " + event);
            runHandling(event, smartHome, type, chain);
        }
    }

    private void runHandling(SensorEvent event, SmartHome smartHome, SensorEventType type, EventSmartHome chain[]){
        for (EventSmartHome eventType : chain) {
            //break прерывает цепь, например когда декоратор не пропускает
            if(eventType.eventRun(event.getObjectId(),smartHome, type)) break;
        }
    }
}
