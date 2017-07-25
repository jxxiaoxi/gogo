package com.mj.gogo.DesignPattern.singleton;

/**
 * Created by liuwei on 7/24/17.
 */

public class Singleton {
    private static final Singleton mSingleton = new Singleton();

    //私有构造方法
    private Singleton() {

    }

    //提供，静态public 方法对外获取实列
    public static Singleton getInstance() {
        return mSingleton;
    }

    /**
     * @return 单列的作用
     */
    public String effect() {
        String effect = "确保某一个类只有一个实例,而且自行实例化并向整个系统提供这个实例";
        return effect;
    }


    /**
     * @return 单列的优点
     */
    public String virtue() {
        String effect = "1.由于单例模式在内存中只有一个实例,减少了内存开支,特别是一个对象需要频繁地创建、销毁时,而且创建或销毁时性能又无法优化,单例模式的优势就非常明显"
                + "\n"
                + "2.由于单例模式只生成一个实例,所以减少了系统的性能开销,当一个对象的产生需要比较多的资源时,如读取配置、产生其他依赖对象时,则可以通过在应用启动时直接产生一个单例对象,然后用永久驻留内存的方式来解决"
                + "\n"
                + "3.单例模式可以避免对资源的多重占用,例如一个写文件动作,由于只有一个实例存在内存中,避免对同一个资源文件的同时写操作"
                + "\n"
                + "4.单例模式可以在系统设置全局的访问点,优化和共享资源访问,例如可以设计一个单例类,负责所有数据表的映射处理";
        return effect;
    }

    /**
     * @return 单列的缺点
     */
    public String defect() {
        String defect = "1.单例模式一般没有接口,扩展很困难,若要扩展,除了修改代码基本上没有第二种途径可以实现"
                + "\n"
                + "2.单例模式对测试是不利的。在并行开发环境中,如果单例模式没有完成,是不能进行测试的,没有接口也不能使用mock的方式虚拟一个对象"
                + "\n"
                + "3.单例模式与单一职责原则有冲突。一个类应该只实现一个逻辑,而不关心它是否是单例的,是不是要单例取决于环境,单例模式把“要单例”和业务逻辑融合在一个类中";
        return defect;
    }
}
