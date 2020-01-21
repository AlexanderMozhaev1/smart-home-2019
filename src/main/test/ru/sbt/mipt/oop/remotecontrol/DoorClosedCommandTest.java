package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import static org.junit.jupiter.api.Assertions.*;

class DoorClosedCommandTest {

    @Test
    void execute() {
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        DoorClosedCommand doorClosedCommand = new DoorClosedCommand(smartHome);
        doorClosedCommand.execute();
        final boolean[] flag = {true};
        smartHome.getRooms().forEach(room -> {
            if(room.getName().equals("hall")) {
                flag[0] = false;
                SmartHomeObjectIterator<Door> smartHomeObjectIterator = room.iteratorDoors();
                while (smartHomeObjectIterator.hasNext()) {
                    Door door = smartHomeObjectIterator.getNext();
                    assertEquals(door.getOpen(), false);
                }
            }
        });
        assertEquals(flag[0], false);
    }
}