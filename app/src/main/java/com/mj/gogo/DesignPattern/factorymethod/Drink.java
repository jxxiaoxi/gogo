package com.mj.gogo.DesignPattern.factorymethod;

/**
 * Created by liuwei on 7/26/17.
 */

public abstract class Drink {
    /**
     * @return 获取饮料的名字
     */
    public abstract String getName();

    /**
     * @return 制作饮料的口味，如甜，酸，常温，加冰等。。。。
     */
    public abstract String takeFlavor();

}
