package com.ezreal.design.model.observer;

/**
 * @author ezreal
 */
public class Plainclothes implements Observer {
    String bname = "Ezreal";

    Plainclothes(){}
    Plainclothes(String bname){
        this.bname = bname;
    }


    @Override
    public void update(String message, String name) {
        System.out.println(bname+":"+name+"那里有新情况："+ message);
    }
}
