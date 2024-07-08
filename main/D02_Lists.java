package main;

import java.util.LinkedList;
import java.util.List;

/**
 * Listen
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D02_Lists {

  public static void main(String[] args) {

    List<String> names = new LinkedList<>();

    names.add("Hans");
    names.add("Peter");
    names.add("Lisa");
    names.add(1, "Heidi");

    for (String name : names) {
      System.out.println(name);
    }
    System.out.println();

    names.remove("Peter");

    for (int i = 0; i < names.size(); i++) {
      String name = names.get(i);
      System.out.println(name);
    }

  }

}
