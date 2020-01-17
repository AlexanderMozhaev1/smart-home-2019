package ru.sbt.mipt.oop.alarm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmStateDeactivateTest {

    @Test
    void activate() {
        Alarm alarm = new Alarm("0000");
        alarm.deactivate("0000");
        alarm.activate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateActivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }

    @Test
    void deactivate() {
        Alarm alarm = new Alarm("0000");
        alarm.deactivate("0000");
        alarm.deactivate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDeactivate;
        boolean actual = true;
        assertEquals(expected,actual);
        alarm.deactivate("0001");
        expected = alarm.getAlarmState() instanceof AlarmStateDeactivate;
        actual = false;
        assertEquals(expected,actual);
    }

    @Test
    void danger() {
        Alarm alarm = new Alarm("0000");
        alarm.deactivate("0000");
        alarm.danger();
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDanger;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}