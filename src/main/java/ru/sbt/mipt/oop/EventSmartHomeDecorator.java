package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.AlarmStateActivate;
import ru.sbt.mipt.oop.alarm.AlarmStateDanger;

public class EventSmartHomeDecorator implements EventSmartHome {
    @Override
    public boolean eventRun(String objectId, SmartHome smartHome, SensorEventType type) {
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateActivate){
            if(type != SensorEventType.ALARM_ACTIVATE && type != SensorEventType.ALARM_DEACTIVATE){
                smartHome.getAlarm().danger();
                System.out.println("danger");
                return true;
            }
        }
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateDanger){
            if(type != SensorEventType.ALARM_ACTIVATE && type != SensorEventType.ALARM_DEACTIVATE){
                return true;
            }
        }
        return false;
    }
}
