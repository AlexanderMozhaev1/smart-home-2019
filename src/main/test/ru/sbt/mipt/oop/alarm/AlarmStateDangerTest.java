package ru.sbt.mipt.oop.alarm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmStateDangerTest {

    @Test
    void activate() {
        Alarm alarm = new Alarm("0000");
        alarm.danger();
        alarm.activate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateActivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }

    @Test
    void deactivate() {
        Alarm alarm = new Alarm("0000");
        alarm.danger();
        alarm.deactivate("0000");
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDeactivate;
        boolean actual = true;
        assertEquals(expected,actual);
    }

    @Test
    void danger() {
        Alarm alarm = new Alarm("0000");
        alarm.danger();
        alarm.danger();
        boolean expected = alarm.getAlarmState() instanceof AlarmStateDanger;
        boolean actual = true;
        assertEquals(expected,actual);
    }
}