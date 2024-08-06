package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Videospiel
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record VideoGame(String title, String publishingYear, VideoGameSystem videoGameSystem,
    double averageRating) implements Comparable<VideoGame> {

  @Override
  public int compareTo(VideoGame otherVideoGame) {
    return this.title.compareTo(otherVideoGame.title);
  }

  public static List<VideoGame> getVideoGames() {
    List<VideoGame> games = new ArrayList<>();

    games.add(
        new VideoGame("The Legend of Zelda: Breath of the Wild", "2017", VideoGameSystem.NSW, 9.7));
    games.add(new VideoGame("Super Mario Odyssey", "2017", VideoGameSystem.NSW, 9.7));
    games.add(new VideoGame("Star Horizon", "2020", VideoGameSystem.NSW, 5.2));
    games.add(new VideoGame("God of War", "2018", VideoGameSystem.PS4, 9.4));
    games.add(new VideoGame("The Last of Us Part II", "2020", VideoGameSystem.PS4, 9.3));
    games.add(new VideoGame("Fallout 4", "2015", VideoGameSystem.PS4, 8.7));
    games.add(new VideoGame("Tony Hawk´s Pro Skater 5", "2015", VideoGameSystem.PS4, 3.2));
    games.add(new VideoGame("Uncharted 4: A Thief´s End", "2016", VideoGameSystem.PS4, 9.3));

    return games;
  }

}
