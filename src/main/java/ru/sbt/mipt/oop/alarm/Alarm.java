package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Alarm  implements Actionable {
    private String code;
    private AlarmState alarmState;

    public Alarm(String code){
        this.code = code;
        this.alarmState = new AlarmStateDeactivate();
    }

    public void activate(String code){ alarmState.activate(this, code); }

    public void deactivate(String code){ alarmState.deactivate(this, code); }

    public void danger(){ alarmState.danger(this); }

    public void setAlarmState(AlarmState alarmState){
        this.alarmState = alarmState;
    }

    public AlarmState getAlarmState(){
        if(alarmState == null) {
            this.alarmState = new AlarmStateDeactivate();
        }
        return alarmState;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    public boolean checkCode(String code) { return this.code.equals(code); }

}
