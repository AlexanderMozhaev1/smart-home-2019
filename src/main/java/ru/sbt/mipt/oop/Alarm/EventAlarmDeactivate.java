package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Event;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Scanner;

public class EventAlarmDeactivate implements Event {
    @Override
    public void eventRun(String objectId, SmartHome smartHome) {
        if(smartHome.getAlarmState() != AlarmStateType.DEACTIVATE){
            System.out.println("Введите пароль");
            Scanner in = new Scanner(System.in);
            String code = in.nextLine();
            smartHome.entryAlramCode(code);
        }
        else
            System.out.println("Сигнализация уже не активна");
    }
}
