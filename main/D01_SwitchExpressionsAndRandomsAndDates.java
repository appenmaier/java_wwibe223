package main;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Demo 1: Switch-Ausdrücke, Pseudozufallszahlen und Datums/Zeitangaben
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D01_SwitchExpressionsAndRandomsAndDates {

  public static void main(String[] args) {

    LocalDateTime now = LocalDateTime.now();
    System.out.println("Jahr: " + now.getYear());
    System.out.println("Tag im Jahr: " + now.getDayOfYear());
    System.out.println("Sekunden: " + now.getSecond());

    LocalDateTime myBirthdate = LocalDateTime.of(1982, 1, 4, 5, 30);
    System.out.println(myBirthdate);

    Random random = new Random();

    for (int i = 0; i < 100; i++) {
      int month = random.nextInt(1, 13);
      System.out.println(month);

      String season = "";

      /* klassischer Switch-Case */
      switch (month) {
        case 12:
        case 1:
        case 2:
          season = "Winter";
          break;
        case 3:
        case 4:
        case 5:
          season = "Frühling";
          break;
        case 6:
        case 7:
        case 8:
          season = "Sommer";
          break;
        case 9:
        case 10:
        case 11:
          season = "Herbst";
          break;
        default:
          season = "";
          break;
      }

      /* Switch-Ausdrücke */
      season = switch (month) {
        case 12, 1, 2 -> "Winter";
        case 3, 4, 5 -> "Frühling";
        case 6, 7, 8 -> "Sommer";
        case 9, 10, 11 -> "Herbst";
        default -> "";
      };

      System.out.println(season);

    }

  }

}
