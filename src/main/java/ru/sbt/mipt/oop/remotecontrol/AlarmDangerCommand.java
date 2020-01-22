package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.AlarmActivate;
import ru.sbt.mipt.oop.strategies.AlarmDanger;

public class AlarmDangerCommand implements Command{
    SmartHome smartHome;

    public AlarmDangerCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        AlarmDanger alarmDanger = new AlarmDanger();
        smartHome.getAlarm().execute(alarmDanger);
    }
}
