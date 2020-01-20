package ru.sbt.mipt.oop.configuration;


import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.adapter.DoorAdapter;
import ru.sbt.mipt.oop.adapter.EventAdapter;
import ru.sbt.mipt.oop.adapter.EventHandlerAdapter;
import ru.sbt.mipt.oop.adapter.LightAdapter;
import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmActivate;
import ru.sbt.mipt.oop.alarm.EventSmartHomeAlarmDeactivate;

@Configuration
@ComponentScan
public class ConfigurationSmartHome {

    @Bean
    SensorEventsManager sensorEventsManager() {
        EventSmartHome chain[] = {new EventSmartHomeDoorClosed(), new EventSmartHomeDoorOpen(),
                new EventSmartHomeLightOn(), new EventSmartHomeLightOff(),
                new EventSmartHomeAlarmActivate(), new EventSmartHomeAlarmDeactivate()};

        EventAdapter adapters[] = {new DoorAdapter(), new LightAdapter()};

        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventHandlerAdapter(smartHome(), eventHandling(), chain, adapters));
        return sensorEventsManager;
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
}

