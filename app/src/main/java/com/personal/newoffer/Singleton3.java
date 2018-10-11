package com.personal.newoffer;

/**
 * Created by zhouxiang on 2018/10/11.
 * 优点：既防止了多线程问题又解决了可能占用资源的问题
 * 缺点：clone、反射、序列化都能破解
 */

public class Singleton3 {

  private static class InnerClass {
    private static Singleton3 mInstance = new Singleton3();
  }

  public Singleton3 getInstance() {
    return InnerClass.mInstance;
  }
}
