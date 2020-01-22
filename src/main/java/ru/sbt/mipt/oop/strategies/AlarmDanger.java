package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlarmStateActivate;

import java.util.Scanner;

public class AlarmDanger implements Action<SmartHome> {

    @Override
    public void execute(SmartHome smartHome) {
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmDanger){
            smartHome.getAlarm().danger();
        }
    }
}
