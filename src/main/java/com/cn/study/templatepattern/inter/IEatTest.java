package com.cn.study.templatepattern.inter;

public class IEatTest {

    public static void main(String[] args) {
        IEat eatFish = new EatFish();
        eatFish.execute();

        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=======================");
        IEat eatRice = new EatRice();
        eatRice.execute();
    }
}
