package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.strategies.RoomLightoff;
import ru.sbt.mipt.oop.strategies.Rooms;

public class LightOffHome{
    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public void offLightHome(SmartHome smartHome){
        RoomLightoff roomLightoff = new RoomLightoff();
        Rooms rooms = new Rooms(roomLightoff);
        smartHome.execute(rooms);
    }
}