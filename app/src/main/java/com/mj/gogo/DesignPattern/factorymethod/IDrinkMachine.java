package com.mj.gogo.DesignPattern.factorymethod;

/**
 * Created by liuwei on 7/28/17.
 * <p>
 * 接口注意语法：1.变量-->必须是public static final 修饰(显式或者隐式),但是接口中一般不定义
 * 　　　　　　　2.方法-->必须是public abstract,实际写的时候可以省略，<T extends Drink> T makeDrink()等价于public abstract <T extends Drink> T makeDrink();
 * <p>
 * 泛型方法：1.必须在返回值前有泛型申明，如<T extends Drink>
 */

public interface IDrinkMachine {
    // public static final String mColor="red" ;
    <T extends Drink> T makeDrink(Class<T> c);
}
