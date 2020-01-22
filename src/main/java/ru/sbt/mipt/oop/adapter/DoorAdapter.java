package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class DoorAdapter implements EventAdapter{
    @Override
    public SensorEvent toSensorEvent(CCSensorEvent ccSensorEvent) {
        if(ccSensorEvent.getEventType().equals("DoorIsOpen"))
            return new SensorEvent(SensorEventType.DOOR_OPEN, ccSensorEvent.getObjectId());
        if(ccSensorEvent.getEventType().equals("DoorIsClosed"))
            return new SensorEvent(SensorEventType.DOOR_CLOSED, ccSensorEvent.getObjectId());
        return null;
    }
}
