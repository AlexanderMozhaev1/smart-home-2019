package ru.sbt.mipt.oop.alarm;

public class AlarmStateDeactivate implements AlarmState {

    @Override
    public void activate(Alarm alarm, String code) {
        alarm.setAlarmState(new AlarmStateActivate());
    }

    @Override
    public void deactivate(Alarm alarm, String code) {

    }

    @Override
    public void danger(Alarm alarm) {
        alarm.setAlarmState(new AlarmStateDanger());
    }
}
