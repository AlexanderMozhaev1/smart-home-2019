package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import static org.junit.jupiter.api.Assertions.*;

class LightOffHomeCommandTest {

    @Test
    void execute() {
        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
        LightOffHomeCommand lightOffHomeCommand = new LightOffHomeCommand(smartHome);
        lightOffHomeCommand.execute();
        smartHome.getRooms().forEach(room -> {
            SmartHomeObjectIterator<Light> smartHomeObjectIterator = room.iteratorLights();
            while (smartHomeObjectIterator.hasNext()){
                Light light = smartHomeObjectIterator.getNext();
                assertEquals(light.isOn(),false);
            }
        });
    }
}