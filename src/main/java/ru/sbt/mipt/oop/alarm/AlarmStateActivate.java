package ru.sbt.mipt.oop.alarm;

public class AlarmStateActivate implements AlarmState {

    @Override
    public void activate(Alarm alarm, String code) {
        if(!alarm.checkCode(code))
            System.out.println("Не верный код.");
    }

    @Override
    public void deactivate(Alarm alarm, String code) {
        if(alarm.checkCode(code))
            alarm.setAlarmState(new AlarmStateDeactivate());
        else
            alarm.danger();
    }

    @Override
    public void danger(Alarm alarm) {
        alarm.setAlarmState(new AlarmStateDanger());
    }
}
