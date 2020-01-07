package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlarmStateActivate;
import ru.sbt.mipt.oop.alarm.AlarmStateDeactivate;

import java.util.Scanner;

public class AlarmDeactivate implements Action<SmartHome>{

    @Override
    public void execute(SmartHome smartHome) {
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateDeactivate){
            System.out.println("Введите пароль");
            Scanner in = new Scanner(System.in);
            String code = in.nextLine();
            smartHome.getAlarm().deactivate(code);
        }
        else
            System.out.println("Сигнализация уже не активна");
    }
}