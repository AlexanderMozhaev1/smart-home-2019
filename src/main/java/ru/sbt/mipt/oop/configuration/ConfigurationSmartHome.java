package ru.sbt.mipt.oop.configuration;


import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.adapter.*;
import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmActivate;
import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmDeactivate;
import ru.sbt.mipt.oop.remotecontrol.*;
import ru.sbt.mipt.oop.strategies.AlarmDanger;

@Configuration
@ComponentScan
public class ConfigurationSmartHome {

    @Bean
    SensorEventsManager sensorEventsManager() {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventHandlerAdapter(smartHome(), eventHandling(), chain(), converterCCSensorEventToSensorEvent()));
        return sensorEventsManager;
    }

    @Bean
    EventSmartHome[] chain(){
        EventSmartHome chain[] = {new EventSmartHomeDecorator(), new EventSmartHomeDoorClosed(), new EventSmartHomeDoorOpen(),
                new EventSmartHomeLightOn(), new EventSmartHomeLightOff(),
                new EventSmartHomeAlarmActivate(), new EventSmartHomeAlarmDeactivate()};
        return chain;
    }

    @Bean
    EventAdapter[] adapters(){
        EventAdapter adapters[] = {new DoorAdapter(), new LightAdapter()};
        return adapters;
    }

    @Bean
    EventHandling eventHandling(){
        return new EventHandlingDoorLightAlarm();
    }

    @Bean
    SmartHome smartHome(){
        return smartHomeTakeEventJson().takeSmartHome();
    }

    @Bean
    SmartHomeTakeEvent smartHomeTakeEventJson(){
        return new SmartHomeTakeEventJson("smart-home-1.js");
    }

    @Bean
    RemoteControl remoteControlRegistry(SmartHome smartHome){
        RemoteControlCommand remoteControlCommand = new RemoteControlCommand();
        remoteControlCommand.addCommand("A",alarmActivateCommand(smartHome));
        remoteControlCommand.addCommand("B",alarmDangerCommand(smartHome));
        remoteControlCommand.addCommand("C",doorClosedCommand(smartHome));
        remoteControlCommand.addCommand("D",lightOffHomeCommand(smartHome));
        remoteControlCommand.addCommand("1",lightOnHallCommand(smartHome));
        remoteControlCommand.addCommand("2",lightOnHomeCommand(smartHome));

        remoteControlRegistry().registerRemoteControl(remoteControlCommand, "0000");
        return remoteControlCommand;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry(){
        return new RemoteControlRegistry();
    }

    @Bean
    AlarmActivateCommand alarmActivateCommand(SmartHome smartHome){
        return new AlarmActivateCommand(smartHome);
    }

    @Bean
    AlarmDangerCommand alarmDangerCommand(SmartHome smartHome){
        return new AlarmDangerCommand(smartHome);
    }

    @Bean
    DoorClosedCommand doorClosedCommand(SmartHome smartHome){
        return new DoorClosedCommand(smartHome);
    }

    @Bean
    LightOffHomeCommand lightOffHomeCommand(SmartHome smartHome){
        return new LightOffHomeCommand(smartHome);
    }

    @Bean
    LightOnHallCommand lightOnHallCommand(SmartHome smartHome){
        return new LightOnHallCommand(smartHome);
    }

    @Bean
    LightOnHomeCommand lightOnHomeCommand(SmartHome smartHome){
        return new LightOnHomeCommand(smartHome);
    }

    @Bean
    ConverterCCSensorEventToSensorEvent converterCCSensorEventToSensorEvent() {return new ConverterCCSensorEventToSensorEvent(adapters());}

}

