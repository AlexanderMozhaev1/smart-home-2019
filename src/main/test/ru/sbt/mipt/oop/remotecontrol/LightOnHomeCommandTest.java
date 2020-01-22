package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import static org.junit.jupiter.api.Assertions.*;

class LightOnHomeCommandTest {

    @Test
    void execute() {
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        LightOnHomeCommand lightOnHomeCommand = new LightOnHomeCommand(smartHome);
        lightOnHomeCommand.execute();
        smartHome.getRooms().forEach(room -> {
            SmartHomeObjectIterator<Light> smartHomeObjectIterator = room.iteratorLights();
            while (smartHomeObjectIterator.hasNext()){
                Light light = smartHomeObjectIterator.getNext();
                assertEquals(light.isOn(),true);
            }
        });
    }
}