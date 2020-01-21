package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

public class ConverterCCSensorEventToSensorEvent implements SensorEventConverter {
    private EventAdapter adapters[];

    public ConverterCCSensorEventToSensorEvent(EventAdapter[] adapters) {
        this.adapters = adapters;
    }

    @Override
    public SensorEvent toSensorEvent(Object o) {
        if(o instanceof CCSensorEvent){
            CCSensorEvent ccSensorEvent = (CCSensorEvent) o;
            for (EventAdapter adapter : adapters) {
                SensorEvent sensorEvent = adapter.toSensorEvent(ccSensorEvent);
                if(sensorEvent != null) return sensorEvent;
            }
        }
        return null;
    }
}
