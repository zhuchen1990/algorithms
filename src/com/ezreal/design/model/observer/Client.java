package com.ezreal.design.model.observer;

public class Client {

    public static void main(String[] args) {
        //定义两个嫌犯
        Criminal xf1 = new Suspects("张三");
        Criminal xf2 = new Suspects("赵六");
        //定义三个观察便衣警察
        Observer o1 = new Plainclothes();
        Observer o2 = new Plainclothes("李四");
        Observer o3 = new Plainclothes("王八");
        //为嫌犯增加观察便衣
        xf1.addObserver(o1);
        xf1.addObserver(o2);
        xf2.addObserver(o1);
        xf2.addObserver(o3);
        //定义嫌犯1的情况
        String message1 = "又卖了一批货";
        String message2 = "老大要下来视察了";
        xf1.notice(message1);
        xf2.notice(message2);

    }

}
