package com.cn.study.templatepattern.inter;

/**
 * 吃饭
 */
public interface IEat {

    default void execute(){
        cook();
        eat();
        wash();
    }
    default void cook(){
        System.out.println("做饭。");
    }

    void eat();

    default void wash(){
        System.out.println("刷锅刷碗。");
    }
}
