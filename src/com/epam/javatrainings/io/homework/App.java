package com.epam.javatrainings.io.homework;

import java.util.List;

public class App {
  public static void main(String[] args) {

      List<Customer> customers = CsvUtility.readCustomersFrom ("/home/arsen/IdeaProjects/epam-trainings/src/com/epam/javatrainings/io/homework/tmp/existed.csv");

      CsvUtility.writeCustomersTo ("com/epam/javatrainings/io/homework/tmp/sorted.csv",CsvUtility.sort (customers));

      Customer customer4 = new Customer("Aaaa","+3749588824",93,"4847040000946793");
      String path = "/home/arsen/IdeaProjects/epam-trainings/src/com/epam/javatrainings/io/homework/tmp/existed.csv";
      Serializer.serialize (customer4,path);
      System.out.println(Serializer.deSerialize (path));

      ExtensionCleaner.erase ("com/epam/javatrainings/io/homework/tmp/Url.html","html");
  }
}
