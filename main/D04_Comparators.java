package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.VideoGame;
import model.VideoGameByRatingDescendingComparator;
import model.VideoGameSystem;

/**
 * Komparatoren
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D04_Comparators {

  public static void main(String[] args) {

    List<Integer> numbers = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<VideoGame> videoGames = new ArrayList<>();

    /* Datensätze hinzufügen */
    numbers.add(4);
    numbers.add(7);
    numbers.add(-2);
    numbers.add(0);

    names.add("Xaver");
    names.add("Lisa");
    names.add("Anna");
    names.add("Bertram");

    videoGames.add(new VideoGame("Hades", "2018", VideoGameSystem.PS4, 9.3));
    videoGames.add(new VideoGame("Dead Cells", "2018", VideoGameSystem.NSW, 8.9));
    videoGames.add(new VideoGame("Metroid Dread", "2021", VideoGameSystem.NSW, 8.8));
    videoGames.add(new VideoGame("Gollum", "2023", VideoGameSystem.PS4, 3.8));

    /* Listen sortieren */
    Collections.sort(numbers);
    Collections.sort(names);
    Collections.sort(videoGames, new VideoGameByRatingDescendingComparator());

    /* Listen ausgeben */
    for (Integer number : numbers) {
      System.out.println(number);
    }
    System.out.println(numbers);

    for (String name : names) {
      System.out.println(name);
    }
    System.out.println(names);

    for (VideoGame videoGame : videoGames) {
      System.out.println(videoGame);
    }
    System.out.println(videoGames);

  }

}
