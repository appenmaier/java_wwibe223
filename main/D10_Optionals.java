package main;

import java.util.Optional;

/**
 * Optionals
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D10_Optionals {

  public static void main(String[] args) {

    String text = getText();
    if (text != null) {
      System.out.println(text.toUpperCase());
    } else {
      System.out.println("text ist null");
    }

    Optional<String> optionalText = getOptionalText();
    if (!optionalText.isEmpty()) {
      System.out.println(optionalText.get().toUpperCase());
    } else {
      System.out.println("text ist null");
    }
    optionalText.ifPresentOrElse(t -> System.out.println(t.toUpperCase()),
        () -> System.out.println("text ist null"));

  }

  public static String getText() {
    String text = null;
    return text;
  }

  public static Optional<String> getOptionalText() {
    String text = null;
    return Optional.ofNullable(text);
  }

}
