package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.EventSmartHome;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.AlarmDeactivate;

import java.util.Scanner;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class EventSmartHomeAlarmDeactivate implements EventSmartHome {
    @Override
    public boolean eventRun(String objectId, SmartHome smartHome, SensorEventType type) {
        if(type != DOOR_CLOSED) return false;
        AlarmDeactivate alarmDeactivate = new AlarmDeactivate();
        smartHome.getAlarm().execute(alarmDeactivate);
        return true;
    }
}
