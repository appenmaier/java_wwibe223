package main;

import java.util.ArrayList;
import java.util.List;
import model.VideoGame;
import model.VideoGameSystem;

/**
 * Demo 3: Object-Methoden und Aufzählungen
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D03_ObjectMethodsAndEnumerations {

  public static void main(String[] args) {

    List<VideoGame> videoGames = new ArrayList<>();

    VideoGame videoGame1 = new VideoGame("Hades", "2018", VideoGameSystem.PS4, 9.3);
    VideoGame videoGame2 = new VideoGame("Hades", "2018", VideoGameSystem.PS4, 9.3);

    videoGames.add(videoGame1);
    videoGames.add(videoGame2);

    for (VideoGame videoGame : videoGames) {
      System.out.println(videoGame);
    }

    System.out.println("videoGame1.hashCode(): " + Integer.toHexString(videoGame1.hashCode()));
    System.out.println("videoGame2.hashCode(): " + Integer.toHexString(videoGame2.hashCode()));

    if (videoGame1 == videoGame2) {
      System.out.println("Beide Spiele sind identisch");
    }

    if (videoGame1.equals(videoGame2)) {
      System.out.println("Beide Spiele sind gleich");
    }

    for (VideoGameSystem s : VideoGameSystem.values()) {
      System.out.println(s);
    }

    VideoGameSystem nsw = VideoGameSystem.valueOf("NSW");
    System.out.println(nsw);

  }

}
