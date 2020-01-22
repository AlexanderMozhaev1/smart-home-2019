package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.EventHandling;
import ru.sbt.mipt.oop.EventSmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.configuration.*;

public class EventHandlerAdapter implements EventHandler {
    private SmartHome smartHome;
    private EventHandling eventHandling;
    private EventSmartHome chain[];
    SensorEventConverter sensorEventConverter;

    public EventHandlerAdapter(SmartHome smartHome, EventHandling eventHandling, EventSmartHome[] chain, SensorEventConverter sensorEventConverter) {
        this.smartHome = smartHome;
        this.eventHandling = eventHandling;
        this.chain = chain;
        this.sensorEventConverter = sensorEventConverter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = sensorEventConverter.toSensorEvent(event);
        this.eventHandling.produceEvent(sensorEvent, this.smartHome, chain);
    }

}
