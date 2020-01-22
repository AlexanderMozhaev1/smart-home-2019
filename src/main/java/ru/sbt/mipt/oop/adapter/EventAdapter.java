package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

public interface EventAdapter {
    SensorEvent toSensorEvent(CCSensorEvent ccSensorEvent);
}
