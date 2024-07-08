package model;

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

}
