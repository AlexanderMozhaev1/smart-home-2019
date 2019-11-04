package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmStateType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class SmartHome {
    private Alarm alarm = new Alarm();

    public AlarmStateType getAlarmState(){ return alarm.getState(); }

    public void entryAlramCode(String code){ alarm.entryCode(code); }

    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void iteratorRoom(Consumer <? super Room>consumer){
        rooms.forEach(consumer);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
