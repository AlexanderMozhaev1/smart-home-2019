package ru.sbt.mipt.oop;

public class EventHandlingDoorClosedOpenLightOnOff implements EventHandling {
    @Override
    public void produceEvent(SensorEvent event, SmartHome smartHome) {
        SensorEventType type = event.getType();
        System.out.println("Got event: " + event);
        EventSmartHome eventSmartHomeType = null;
        switch (type){
            case LIGHT_ON:
                eventSmartHomeType = new EventSmartHomeLightOn();
                break;
            case LIGHT_OFF:
                eventSmartHomeType = new EventSmartHomeLightOff();
                break;
            case DOOR_OPEN:
                eventSmartHomeType = new EventSmartHomeDoorOpen();
                break;
            case DOOR_CLOSED:
                eventSmartHomeType = new EventSmartHomeDoorClosed();
                break;
        }
        eventSmartHomeType.eventRun(event.getObjectId(),smartHome);
    }
}
