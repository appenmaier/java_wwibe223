package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import model.VideoGame;
import model.VideoGameByRatingDescendingComparator;
import model.VideoGamePrinter;
import model.VideoGameSystem;

/**
 * Lokale Klassen, Anonyme Klassen, Lambda-Ausdruecke, Methodenreferenzen
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D06_InnerClasses {

  private static List<VideoGame> videoGames;

  public static void main(String[] args) {

    /* Videospiele erzeugen */
    videoGames = new ArrayList<>();
    videoGames.add(new VideoGame("Hades", "2018", VideoGameSystem.PS4, 9.3));
    videoGames.add(new VideoGame("Dead Cells", "2018", VideoGameSystem.NSW, 8.9));
    videoGames.add(new VideoGame("Metroid Dread", "2021", VideoGameSystem.NSW, 8.8));
    videoGames.add(new VideoGame("Gollum", "2023", VideoGameSystem.PS4, 3.8));

    /* Vidoespiele ausgeben */
    for (VideoGame v : videoGames) {
      System.out.println(v);
    }
    System.out.println();

    /* Aeussere Klassen */
    sortVideoGamesByOuterClass();
    printVideoGamesByOuterClass();
    System.out.println();

    /* Lokale Klassen */
    sortVideoGamesByLocalClass();
    printVideoGamesByLocalClass();
    System.out.println();

    /* Anonyme Klassen */
    sortVideoGamesByAnonymousClass();
    printVideoGamesByAnonymousClass();
    System.out.println();

    /* Lambda-Ausdruecke */
    sortVideoGamesByLambdaExpression();
    printVideoGamesByLambdaExpression();
    System.out.println();

    /* Methodenreferenzen */
    sortVideoGamesByMethodReference();
    printVideoGamesByMethodReference();

  }

  public static void sortVideoGamesByOuterClass() {
    Collections.sort(videoGames, new VideoGameByRatingDescendingComparator());
  }

  public static void sortVideoGamesByLocalClass() {
    class VideoGameByPublishingYearAscendingComparator implements Comparator<VideoGame> {

      @Override
      public int compare(VideoGame videoGame1, VideoGame videoGame2) {
        return videoGame1.publishingYear().compareTo(videoGame2.publishingYear());
      }

    }

    Collections.sort(videoGames, new VideoGameByPublishingYearAscendingComparator());
  }

  public static void sortVideoGamesByAnonymousClass() {
    Collections.sort(videoGames, new Comparator<VideoGame>() {

      @Override
      public int compare(VideoGame videoGame1, VideoGame videoGame2) {
        return videoGame2.publishingYear().compareTo(videoGame1.publishingYear());
      }

    });
  }

  public static void sortVideoGamesByLambdaExpression() {
    Collections.sort(videoGames,
        (videoGame1, videoGame2) -> videoGame2.title().compareTo(videoGame1.title()));
  }

  public static void sortVideoGamesByMethodReference() {
    Collections.sort(videoGames, Comparator.comparing(VideoGame::publishingYear).reversed());
  }

  public static void printVideoGamesByOuterClass() {
    videoGames.forEach(new VideoGamePrinter());
  }

  public static void printVideoGamesByLocalClass() {
    class VideoGamePrinterLocal implements Consumer<VideoGame> {

      @Override
      public void accept(VideoGame videoGame) {
        System.out.println(videoGame);
      }

    }

    videoGames.forEach(new VideoGamePrinterLocal());
  }

  public static void printVideoGamesByAnonymousClass() {
    videoGames.forEach(new Consumer<VideoGame>() {

      @Override
      public void accept(VideoGame videoGame) {
        System.out.println(videoGame);
      }

    });
  }

  public static void printVideoGamesByLambdaExpression() {
    videoGames.forEach(videoGame -> System.out.println(videoGame));
  }

  public static void printVideoGamesByMethodReference() {
    videoGames.forEach(System.out::println);
  }

}
