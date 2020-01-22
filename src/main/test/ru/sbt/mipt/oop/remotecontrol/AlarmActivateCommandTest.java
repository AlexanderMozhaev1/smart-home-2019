package ru.sbt.mipt.oop.remotecontrol;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlarmStateDeactivate;
import ru.sbt.mipt.oop.strategies.AlarmActivate;

import static org.junit.jupiter.api.Assertions.*;

class AlarmActivateCommandTest {

    @Test
    void execute() {
        SmartHome smartHome = new SmartHome(null, "0000");
        smartHome.getAlarm().danger();
        AlarmActivateCommand alarmActivateCommand = new AlarmActivateCommand(smartHome);
        alarmActivateCommand.execute();

        boolean expected = smartHome.getAlarm().getAlarmState() instanceof AlarmActivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}