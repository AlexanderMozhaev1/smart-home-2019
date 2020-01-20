package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class LightAdapter implements EventAdapter{
    @Override
    public SensorEvent toSensorEvent(CCSensorEvent ccSensorEvent) {
        if(ccSensorEvent.getEventType().equals("LightIsOn"))
            return new SensorEvent(SensorEventType.LIGHT_ON, ccSensorEvent.getObjectId());
        if(ccSensorEvent.getEventType().equals("LightIsOff"))
            return new SensorEvent(SensorEventType.LIGHT_OFF, ccSensorEvent.getObjectId());
        return null;
    }
}
