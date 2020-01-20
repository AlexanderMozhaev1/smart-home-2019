package ru.sbt.mipt.oop.alarm;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.strategies.AlarmDeactivate;

import static org.junit.jupiter.api.Assertions.*;

class AlarmStateActivateTest {

    @Test
    void activate() {
        Alarm alarm = new Alarm("0000");
        alarm.activate("0000");
        alarm.activate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateActivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }

    @Test
    void deactivate() {
        Alarm alarm = new Alarm("0000");
        alarm.activate("0000");
        alarm.deactivate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDeactivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }

    @Test
    void danger() {
        Alarm alarm = new Alarm("0000");
        alarm.activate("0000");
        alarm.danger();
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDanger;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}