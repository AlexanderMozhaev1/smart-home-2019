package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.AlarmActivate;
import ru.sbt.mipt.oop.strategies.AlarmDanger;

import static org.junit.jupiter.api.Assertions.*;

class AlarmDangerCommandTest {

    @Test
    void execute() {
        SmartHome smartHome = new SmartHome(null, "0000");
        AlarmDangerCommand alarmDangerCommand = new AlarmDangerCommand(smartHome);
        alarmDangerCommand.execute();
        boolean expected = smartHome.getAlarm().getAlarmState() instanceof AlarmDanger;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}