package com.fzd.testingproject.si;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIntegrationFileCopyExample {

  public static void main(String[] args) throws InterruptedException, IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "fileCopyApplicationContext.xml");
    try {
      System.out.println("********** start to run Spring Integration **************");
      Thread.sleep(2000);
    } finally {
//   t   context.close();
    }
  }
}
