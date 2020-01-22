package ru.sbt.mipt.oop.remotecontrol;

import rc.RemoteControl;

import java.util.HashMap;

public class RemoteControlCommand implements RemoteControl {
    HashMap<String,Command> comands;

    public RemoteControlCommand() {
        this.comands = new HashMap<>();
    }

    public void addCommand(String buttonCode, Command command){
        comands.put(buttonCode, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (comands.containsKey(buttonCode)) {
            comands.get(buttonCode).execute();
        }
    }
}
