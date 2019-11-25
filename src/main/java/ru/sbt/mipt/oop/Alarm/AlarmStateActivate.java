package ru.sbt.mipt.oop.Alarm;

public class AlarmStateActivate implements AlarmState {
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
        else{
            alarm.setAlarmState(new AlarmStateDanger());
        }
    }

    @Override
    public AlarmStateType getState() {
        return AlarmStateType.ACTIVATE;
    }
}
