package ru.sbt.mipt.oop;

import rc.RemoteControl;
import rc.RemoteControlRegistry;

public class EventRemoteControl implements RemoteControl {
    private SmartHome smartHome;
    EventRemoteControl(SmartHome _smartHome){
        this.smartHome = _smartHome;
    }
    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        
    }
}
