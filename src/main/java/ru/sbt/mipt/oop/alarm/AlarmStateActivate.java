package ru.sbt.mipt.oop.alarm;

public class AlarmStateActivate implements AlarmState {

    public AlarmState getState() {
        return this;
    }

    @Override
    public void activate(Alarm alarm, String code) {

    }

    @Override
    public void deactivate(Alarm alarm, String code) {
        alarm.setAlarmState(new AlarmStateDeactivate());
    }

    @Override
    public void danger(Alarm alarm) {
        alarm.setAlarmState(new AlarmStateDanger());
    }
}
