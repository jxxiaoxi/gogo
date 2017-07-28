package com.mj.gogo.DesignPattern.factorymethod;

/**
 * Created by liuwei on 7/26/17.
 */

public class Tea extends Drink {
    public Tea() {

    }

    @Override
    public String getName() {
        return "这是茶";
    }

    @Override
    public String takeFlavor() {
        return "==>多放茶叶";
    }
}
