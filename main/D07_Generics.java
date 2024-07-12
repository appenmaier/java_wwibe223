package main;

import model.Box;
import model.IntegerBox;
import model.StringBox;

/**
 * Java Generics
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D07_Generics {

  public static void main(String[] args) {

    /* Integer-Box */
    IntegerBox integerBox = new IntegerBox();

    integerBox.setContentA(42);
    integerBox.setContentB(127);

    Integer int1 = integerBox.getContentA();
    Integer int2 = integerBox.getContentB();

    /* String-Box */
    StringBox stringBox = new StringBox();

    stringBox.setContentA("Hans");
    stringBox.setContentB("Lisa");

    String string1 = stringBox.getContentA();
    String string2 = stringBox.getContentB();

    /* Box */
    Box box = new Box();

    box.setContentA("Hans");
    box.setContentB(127);

    Integer int3 = (Integer) box.getContentA();
    String string3 = (String) box.getContentB();

  }

}
