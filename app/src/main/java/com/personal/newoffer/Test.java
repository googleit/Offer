package com.personal.newoffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhouxiang on 2018/10/11.
 */

public class Test {
  public static void main(String[] args) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
      oos.writeObject(Singleton2.getInstance());
      File file = new File("tempFile");
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
      Singleton2 singleton2 = (Singleton2) ois.readObject();
      singleton2.test();
      System.out.println(singleton2 == Singleton2.getInstance());
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(Singleton4.INSTANCE);
    }
  }
}
