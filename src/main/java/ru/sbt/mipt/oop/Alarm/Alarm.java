package ru.sbt.mipt.oop.Alarm;

public class Alarm {
    private String code;
    private AlarmState alarmState;
    public Alarm(){
        this.code = null;
        this.alarmState = new AlarmStateDeactivate();
    }

    public AlarmStateType getState(){
        return alarmState.getState();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setAlarmState(AlarmState _alarmState){
        this.alarmState = _alarmState;
    }

    public void entryCode(String code){
        alarmState.setCode(this, code);
    }

    public boolean processAlarmState() {
        return alarmState.processAlarmState();
    }
 }
