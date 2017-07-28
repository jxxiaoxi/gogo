package com.mj.gogo.DesignPattern.factorymethod;

/**
 * Created by liuwei on 7/26/17.
 */

public class Coke extends Drink {
    @Override
    public String getName() {
        return "这是可乐";
    }

    @Override
    public String takeFlavor() {
        return "==>加冰";
    }
}
