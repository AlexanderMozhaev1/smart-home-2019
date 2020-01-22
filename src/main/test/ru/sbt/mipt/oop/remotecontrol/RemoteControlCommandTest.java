package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeTakeEvent;
import ru.sbt.mipt.oop.SmartHomeTakeEventJson;
import ru.sbt.mipt.oop.strategies.AlarmActivate;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControlCommandTest {

    @Test
    void remoteControlCommandTest() {
        SmartHome smartHome = new SmartHome(null, "0000");
        AlarmActivateCommand alarmActivateCommand = new AlarmActivateCommand(smartHome);
        RemoteControlCommand remoteControlCommand = new RemoteControlCommand();
        remoteControlCommand.addCommand("o_O", alarmActivateCommand);
        remoteControlCommand.onButtonPressed("o_O", "O_o");
        boolean expected = smartHome.getAlarm().getAlarmState() instanceof AlarmActivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}