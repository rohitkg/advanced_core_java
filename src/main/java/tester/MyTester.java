package tester;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyTester {

  public static void main(String[] args) throws Throwable {
    Properties properties = new Properties();
    properties.load(new FileReader("TestConfig.properties"));
    String plumberClass = properties.getProperty("plumber");
    System.out.println("Target class is " + plumberClass);
    Class cl = Class.forName(plumberClass);

//    System.setSecurityManager(new SecurityManager());

    Object p = (cl.newInstance());
//    p.unblockDrain();

    Method[] methods = cl.getDeclaredMethods();
    for (Method m : methods) {
      System.out.println("> " + m);
//      if (m.getName().equals("unblockDrain")) {
//        System.out.println("Found unblock drain");
//        m.invoke(p);
//      }

      RunMe annot = m.getAnnotation(RunMe.class);
      if (annot != null) {
        m.setAccessible(true);
        System.out.println("Found RunMe annotation!");
        m.invoke(p, annot.text(), annot.value());
      }
    }
  }
}
