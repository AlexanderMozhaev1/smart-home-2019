package ru.sbt.mipt.oop.adapter;

import ru.sbt.mipt.oop.SensorEvent;

public interface SensorEventConverter {
    SensorEvent toSensorEvent(Object o);
}
