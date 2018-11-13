package com.ezreal.design.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Suspects implements Criminal {

    private String name = "大熊";
    private List<Observer> observerList = new ArrayList<Observer>();
    Suspects(){}
    Suspects(String name){
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer) {
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    @Override
    public void notice(String message) {
        for(Observer observer:observerList){
            observer.update(message,name);
        }
    }
}
