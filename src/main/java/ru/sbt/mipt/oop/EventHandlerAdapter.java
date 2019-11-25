package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.Alarm.AlarmStateType;
import ru.sbt.mipt.oop.Alarm.EventAlarmActivate;
import ru.sbt.mipt.oop.Alarm.EventAlarmDeactivate;
import ru.sbt.mipt.oop.Door.EventDoorClosed;
import ru.sbt.mipt.oop.Door.EventDoorOpen;
import ru.sbt.mipt.oop.Light.EventLightOff;
import ru.sbt.mipt.oop.Light.EventLightOn;

public class EventHandlerAdapter implements EventHandler {
    private SmartHome smartHome;
    EventHandlerAdapter(SmartHome _smartHome){
        this.smartHome = _smartHome;
    }
    @Override
    public void handleEvent(CCSensorEvent event) {
        String type = event.getEventType();
        System.out.println("Got event: " + event);
        Event eventType = getEventType(type);
        controlAlarmState(event, smartHome, eventType);
    }

    private Event getEventType(String type) {
        Event eventType = null;
        switch (type){
            case "LightIsOn":
                eventType = new EventLightOn();
                break;
            case "LightIsOff":
                eventType = new EventLightOff();
                break;
            case "DoorIsOpen":
                eventType = new EventDoorOpen();
                break;
            case "DoorIsClosed":
                eventType = new EventDoorClosed();
                break;
            case "DoorIsLocked":
                eventType = new EventAlarmActivate();
                break;
            case "DoorIsUnlocked":
                eventType = new EventAlarmDeactivate();
                break;
        }
        return eventType;
    }

    public void controlAlarmState(CCSensorEvent event, SmartHome smartHome, Event eventType){
        if(smartHome.getAlarmState() == AlarmStateType.ACTIVATE){
            if(event.getEventType() != "DoorIsLocked" && event.getEventType() != "DoorIsUnlocked" ){
                smartHome.entryAlramCode(null);
                return;
            }
        }
        if(smartHome.getAlarmState() == AlarmStateType.ACTIVATE){
            if(event.getEventType() != "DoorIsLocked" && event.getEventType() != "DoorIsUnlocked" ){
                return;
            }
        }
        eventType.eventRun(event.getObjectId(),smartHome);
    }
}
