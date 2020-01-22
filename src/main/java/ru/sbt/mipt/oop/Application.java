package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.configuration.ConfigurationSmartHome;

public class Application {

    public static void main(String... args){
//        EventSmartHome chain[] = {new EventSmartHomeDoorClosed(), new EventSmartHomeDoorOpen(),
//                new EventSmartHomeLightOn(), new EventSmartHomeLightOff(),
//                new EventSmartHomeAlarmActivate(), new EventSmartHomeAlarmDeactivate()};
//
//        EventAdapter adapters[] = {new DoorAdapter(), new LightAdapter()};
//
//        EventHandling eventHandling = new EventHandlingDoorLightAlarm();
//
//        SmartHomeTakeEvent smartHomeTakeEventJson = new SmartHomeTakeEventJson("smart-home-1.js");
//        SmartHome smartHome = smartHomeTakeEventJson.takeSmartHome();
//
//        SensorEventsManager sensorEventsManager = new SensorEventsManager();
//        sensorEventsManager.registerEventHandler(new EventHandlerAdapter(smartHome,eventHandling,chain,adapters));
//        sensorEventsManager.start();



        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSmartHome.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }
}
