package ru.sbt.mipt.oop;

import java.util.ArrayList;

public class SmartHomeObjectIterator<T> {
    int index;
    private ArrayList<T> arrayList;

    public boolean hasNext(){
        if(index >= arrayList.size())
            return false;
        return true;
    }
    public T getNext(){
        if(!hasNext())
            return null;
        return arrayList.get(index++);
    }

    public SmartHomeObjectIterator(ArrayList<T> collection) {
        this.index = 0;
        this.arrayList = collection;
    }
}
