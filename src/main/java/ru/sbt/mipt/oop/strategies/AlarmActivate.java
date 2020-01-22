package ru.sbt.mipt.oop.strategies;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlarmStateActivate;

import java.util.Scanner;

public class AlarmActivate implements Action<SmartHome>{

    @Override
    public void execute(SmartHome smartHome) {
        if(smartHome.getAlarm().getAlarmState() instanceof AlarmStateActivate){
            System.out.println("Введите пароль");
            Scanner in = new Scanner(System.in);
            String code = in.nextLine();
            smartHome.getAlarm().activate(code);
        }
        else
            System.out.println("Сигнализация уже активна");
    }
}
