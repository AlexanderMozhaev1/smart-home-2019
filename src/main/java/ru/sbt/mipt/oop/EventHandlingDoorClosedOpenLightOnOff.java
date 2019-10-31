package ru.sbt.mipt.oop;

public class EventHandlingDoorClosedOpenLightOnOff implements EventHandling {
    @Override
    public void produceEvent(SensorEvent event, SmartHome smartHome) {
        SensorEventType type = event.getType();
        System.out.println("Got event: " + event);
        Event eventType = null;
        switch (type){
            case LIGHT_ON:
                eventType = new EventLightOn();
                break;
            case LIGHT_OFF:
                eventType = new EventLightOff();
                break;
            case DOOR_OPEN:
                eventType = new EventDoorOpen();
                break;
            case DOOR_CLOSED:
                eventType = new EventDoorClosed();
                break;
        }
        eventType.eventRun(event.getObjectId(),smartHome);
    }
}
