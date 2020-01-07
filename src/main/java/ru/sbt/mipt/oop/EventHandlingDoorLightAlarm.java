package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.AlarmStateActivate;
import ru.sbt.mipt.oop.alarm.AlarmStateDanger;

public class EventHandlingDoorLightAlarm implements EventHandling {
    @Override
    public void produceEvent(SensorEvent event, SmartHome smartHome, EventSmartHome chain[]) {
        SensorEventType type = event.getType();
        System.out.println("Got event: " + event);
        runHandling(event, smartHome, type, chain);
    }

    private void runHandling(SensorEvent event, SmartHome smartHome, SensorEventType type, EventSmartHome chain[]){
        for (EventSmartHome eventType : chain) {
            if(controlAlarmState(event, smartHome, eventType, type)) break;
        }
    }

    private boolean controlAlarmState(SensorEvent event, SmartHome smartHome, EventSmartHome eventType, SensorEventType type){
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateActivate){
            if(event.getType() != SensorEventType.ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE){
                smartHome.getAlarm().danger();
                System.out.println("danger");
                return true;
            }
        }
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateDanger){
            if(event.getType() != SensorEventType.ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE){
                return true;
            }
        }
        return eventType.eventRun(event.getObjectId(),smartHome, type);
    }
}
