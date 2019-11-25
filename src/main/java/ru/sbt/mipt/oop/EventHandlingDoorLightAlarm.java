package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.AlarmStateType;
import ru.sbt.mipt.oop.Alarm.EventAlarmActivate;
import ru.sbt.mipt.oop.Alarm.EventAlarmDeactivate;
import ru.sbt.mipt.oop.Door.EventDoorClosed;
import ru.sbt.mipt.oop.Door.EventDoorOpen;
import ru.sbt.mipt.oop.Light.EventLightOff;
import ru.sbt.mipt.oop.Light.EventLightOn;

public class EventHandlingDoorLightAlarm implements EventHandling {
    @Override
    public void produceEvent(SensorEvent event, SmartHome smartHome) {
        SensorEventType type = event.getType();
        System.out.println("Got event: " + event);
        Event eventType = null;
        switch (type){
            case LIGHT_ON:
                eventType = new EventLightOn();
                break;
            case LIGHT_OFF:
                eventType = new EventLightOff();
                break;
            case DOOR_OPEN:
                eventType = new EventDoorOpen();
                break;
            case DOOR_CLOSED:
                eventType = new EventDoorClosed();
                break;
            case ALARM_ACTIVATE:
                eventType = new EventAlarmActivate();
                break;
            case ALARM_DEACTIVATE:
                eventType = new EventAlarmDeactivate();
                break;
        }

        controlAlarmState(event, smartHome, eventType);
    }
    public void controlAlarmState(SensorEvent event, SmartHome smartHome, Event eventType){
        if(smartHome.getAlarmState() == AlarmStateType.ACTIVATE){
            if(event.getType() != SensorEventType.ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE){
                smartHome.entryAlramCode(null);
                return;
            }
        }
        if(smartHome.getAlarmState() == AlarmStateType.ACTIVATE){
            if(event.getType() != SensorEventType.ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE){
                return;
            }
        }
        eventType.eventRun(event.getObjectId(),smartHome);
    }
}
