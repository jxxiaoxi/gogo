package com.mj.gogo.DesignPattern.factorymethod;

import com.mj.commonlib.utils.LogUtils;

/**
 * Created by liuwei on 7/26/17.
 * 相当于工厂类
 * <p>
 * 1.反射　获取类的３种方法
 * Class clazz = Class.forName("com.mj.gogo.DesignPattern.factorymethod.DrinkMachine");
 * Class clazz1 = new DrinkMachine().getClass();
 * Class class2 = DrinkMachine.class;
 */

public class DrinkMachine implements IDrinkMachine {

    @Override
    public <T extends Drink> T makeDrink(Class<T> c) {
        Drink drink = null;
        try {
            //获取当前的类的实列，
            drink = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(this.getClass().getName(), " make drink error");
        }
        //返回具体的子类类型
        return (T) drink;
    }
}
