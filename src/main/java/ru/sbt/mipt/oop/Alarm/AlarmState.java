package ru.sbt.mipt.oop.Alarm;

public interface AlarmState {
    public boolean processAlarmState();
    public void setCode(Alarm alarm, String code);
    public AlarmStateType getState();
}
