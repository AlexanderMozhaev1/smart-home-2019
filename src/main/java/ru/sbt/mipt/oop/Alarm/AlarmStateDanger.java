package ru.sbt.mipt.oop.Alarm;

public class AlarmStateDanger implements AlarmState {
    @Override
    public boolean processAlarmState() {
        return false;
    }

    @Override
    public void setCode(Alarm alarm, String code) {
        if(alarm.getCode().equals(code)){
            alarm.setAlarmState(new AlarmStateDeactivate());
            alarm.setCode(null);
        }
    }

    @Override
    public AlarmStateType getState() {
        return AlarmStateType.DANGER;
    }
}
