package com.fzd.testingproject.si;

import java.io.File;
import org.springframework.stereotype.Component;

@Component
public class FileHandler {

  public File handleFile(File input) {
    System.out.println("Copying file: " + input.getAbsolutePath());
    System.out.println(input.getName());
    return input;
  }
}
