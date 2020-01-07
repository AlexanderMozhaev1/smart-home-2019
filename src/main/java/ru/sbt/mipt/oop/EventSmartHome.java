package ru.sbt.mipt.oop;

public interface EventSmartHome {
    public boolean eventRun(String objectId, SmartHome smartHome, SensorEventType type);
}
