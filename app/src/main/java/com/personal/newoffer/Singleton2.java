package com.personal.newoffer;

import java.io.Serializable;

/**
 * Created by zhouxiang on 2018/10/11.
 * 饿汉式+双重判断
 * 第1个判空是为了防止每次都执行synchronized,提升效率
 * 第2个判空是为了防止多个线程同时进入了第1个判空里会导致创建了多个对象
 * 优点：双重判空既防止了多线程问题又不会影响效率
 * 缺点：clone和反射以及序列化都会破解这种单例实现方式
 */

public class Singleton2 implements Serializable {
  private static Singleton2 mInstance;
  private static boolean flag = false;


  /**
   * 防止被反射
   */
  private Singleton2() {
    if (!flag) {
      flag = true;
    } else {
      try {
        throw new Exception("已经创建过一个对象了");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static Singleton2 getInstance() {
    if (mInstance == null) {
      synchronized (Singleton2.class) {
        if (mInstance == null) {
          mInstance = new Singleton2();
        }
      }
    }
    return mInstance;
  }


  /**
   * 重新clone方法，防止被clone获取新的对象
   * 
   * @return
   * @throws CloneNotSupportedException
   */
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return getInstance();
  }

  /**
   * 下面通过序列化、反序列化就会导致创建新的对象
   * ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
   * oos.writeObject(Singleton2.getInstance());
   * File file = new File("tempFile");
   * ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
   * Singleton2 singleton2 = (Singleton2)ois.readObject();
   */
  // 这个就是为了防止反序列化（readObject)时获取到新的对象
  private Object readResolve() {
    return mInstance;
  }

  public void test() {
    System.out.println("test");
  }
}
