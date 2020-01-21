package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.EventHandling;
import ru.sbt.mipt.oop.EventSmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class EventHandlerAdapter implements EventHandler {
    private SmartHome smartHome;
    private EventHandling eventHandling;
    private EventSmartHome chain[];
    private EventAdapter adapters[];

    public EventHandlerAdapter(SmartHome smartHome, EventHandling eventHandling, EventSmartHome[] chain, EventAdapter adapters[]) {
        this.smartHome = smartHome;
        this.eventHandling = eventHandling;
        this.chain = chain;
        this.adapters = adapters;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEventConverter sensorEventConverter = new ConverterCCSensorEventToSensorEvent(adapters);
        SensorEvent sensorEvent = sensorEventConverter.toSensorEvent(event);
        this.eventHandling.produceEvent(sensorEvent, this.smartHome, chain);
    }

}
