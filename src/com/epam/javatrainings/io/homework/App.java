package com.epam.javatrainings.io.homework;

import java.util.List;

public class App {
  public static void main(String[] args) {

      List<Customer> customers = CsvUtility.readCustomersFrom ("com/epam/javatrainings/io/homework/tmp");

      CsvUtility.writeCustomersTo ("com/epam/javatrainings/io/homework/tmp",CsvUtility.sort (customers));

      Customer customer4 = new Customer("Aaaa","+3749588824",93,"4847040000946793");
      String path = "com/epam/javatrainings/io/homework/tmp";
      Serializer.serialize (customer4,path);
      System.out.println(Serializer.deSerialize (path));

      ExtensionCleaner.erase ("com/epam/javatrainings/io/homework/tmp/Url.html","html");
  }
}
