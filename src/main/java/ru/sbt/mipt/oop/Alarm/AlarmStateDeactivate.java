package ru.sbt.mipt.oop.Alarm;

public class AlarmStateDeactivate implements AlarmState {
    @Override
    public boolean processAlarmState() {
        return true;
    }

    @Override
    public void setCode(Alarm alarm, String code) {
        alarm.setCode(code);
        alarm.setAlarmState(new AlarmStateActivate());
    }

    @Override
    public AlarmStateType getState() {
        return AlarmStateType.DEACTIVATE;
    }
}
