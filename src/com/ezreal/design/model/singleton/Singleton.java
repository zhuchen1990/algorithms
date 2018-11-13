package com.ezreal.design.model.singleton;

public class Singleton {
    /**
     * 1、饿汉式（静态常量）[可用]
     */
    private final static Singleton INSTANCE = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return INSTANCE;
    }



}
