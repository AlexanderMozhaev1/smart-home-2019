package ru.sbt.mipt.oop;

import org.springframework.stereotype.Component;

@Component
public interface EventHandling {
    void produceEvent(SensorEvent event, SmartHome smartHome, EventSmartHome chain[]);
}
