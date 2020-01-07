package ru.sbt.mipt.oop.alarm;

public interface AlarmState {
    public void activate(Alarm alarm, String code);
    public void deactivate(Alarm alarm, String code);
    public void danger(Alarm alarm);
}
