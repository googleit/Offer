package com.personal.newoffer;

/**
 * Created by zhouxiang on 2018/10/11.
 * 单例 饿汉式
 * 优点：简单，没有多线程问题
 * 缺点：浪费控件，占用资源，如果一直不调用getIntance,那么创建的对象就是浪费了，
 */

public class Singleton1 {

  //只有类第一次加载时才会调用
  private static Singleton1 mInstance = new Singleton1();

  public static Singleton1 getInstance() {
    return mInstance;
  }
}
