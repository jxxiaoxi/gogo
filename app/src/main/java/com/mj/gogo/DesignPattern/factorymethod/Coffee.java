package com.mj.gogo.DesignPattern.factorymethod;

/**
 * Created by liuwei on 7/26/17.
 */

public class Coffee extends Drink {

    @Override
    public String getName() {
        return "这是咖啡";
    }

    @Override
    public String takeFlavor() {
        return "==>常温加糖";
    }
}
