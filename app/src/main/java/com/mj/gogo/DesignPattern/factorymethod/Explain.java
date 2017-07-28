package com.mj.gogo.DesignPattern.factorymethod;

import com.mj.gogo.DesignPattern.IExplain;

/**
 * Created by liuwei on 7/28/17.
 */

public class Explain implements IExplain {
    @Override
    public String effect() {
        String effect = "定义一个用于创建对象的接口,让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。";
        return effect;

    }

    @Override
    public String virtue() {
        String virtue = "1.良好的封装性,代码结构清晰。一个对象创建是有条件约束的,如一个调用者需要一个具体的产品对象,只要知道这个产品的类名(或约束字符串)就可以了,不用知道创建对象的艰辛过程,降低模块间的耦合"
                + "\n"
                + "2.工厂方法模式的扩展性非常优秀。在增加产品类的情况下,只要适当地修改具体的工厂类或扩展一个工厂类,就可以完成“拥抱变化”。"
                + "\n"
                + "3.屏蔽产品类。这一特点非常重要,产品类的实现如何变化,调用者都不需要关心,它只需要关心产品的接口,只要接口保持不变,系统中的上层模块就不要发生变化"
                + "\n"
                + "4.工厂方法模式是典型的解耦框架。高层模块值需要知道产品的抽象类,其他的实现类都不用关心";
        return virtue;
    }

    @Override
    public String defect() {
        String defect = "";
        return defect;
    }

    public String useScene() {
        String use_scene = "1.工厂方法模式是new一个对象的替代品,所以在所有需要生成对象的地方都可以使用\n 2.需要灵活的、可扩展的框架时,可以考虑采用工厂方法模式\n 3.工厂方法模式可以用在异构项目中,可以使用在测试驱动开发的框架下";
        return use_scene;

    }
}
