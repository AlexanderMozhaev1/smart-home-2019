package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.strategies.AlarmActivate;

public class AlarmActivateCommand implements Command {
    SmartHome smartHome;

    public AlarmActivateCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        AlarmActivate alarmActivate = new AlarmActivate();
        smartHome.getAlarm().execute(alarmActivate);
    }
}
