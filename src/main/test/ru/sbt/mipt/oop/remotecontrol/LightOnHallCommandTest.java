package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import static org.junit.jupiter.api.Assertions.*;

class LightOnHallCommandTest {

    @Test
    void execute() {
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        LightOnHomeCommand lightOnHomeCommand = new LightOnHomeCommand(smartHome);
        lightOnHomeCommand.execute();
        final boolean[] flag = {true};
        smartHome.getRooms().forEach(room -> {
            if(room.getName().equals("hall")) {
                flag[0] = false;
                SmartHomeObjectIterator<Light> smartHomeObjectIterator = room.iteratorLights();
                while (smartHomeObjectIterator.hasNext()) {
                    Light light = smartHomeObjectIterator.getNext();
                    assertEquals(light.isOn(), true);
                }
            }
        });
        assertEquals(flag[0], false);
    }
}