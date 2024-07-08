package model;

import java.util.Objects;

/**
 * Videospiel
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class VideoGame {

  private final String title;
  private final String publishingYear;
  private final VideoGameSystem videoGameSystem;
  private double averageRating;

  public VideoGame(String title, String publishingYear, VideoGameSystem videoGameSystem,
      double averageRating) {
    this.title = title;
    this.publishingYear = publishingYear;
    this.videoGameSystem = videoGameSystem;
    this.averageRating = averageRating;
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(double averageRating) {
    this.averageRating = averageRating;
  }

  public String title() {
    return title;
  }

  public String publishingYear() {
    return publishingYear;
  }

  public VideoGameSystem videoGameSystem() {
    return videoGameSystem;
  }

  @Override
  public String toString() {
    return "VideoGame [title=" + title + ", publishingYear=" + publishingYear + ", videoGameSystem="
        + videoGameSystem + ", averageRating=" + averageRating + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageRating, publishingYear, title, videoGameSystem);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VideoGame other = (VideoGame) obj;
    return Double.doubleToLongBits(averageRating) == Double.doubleToLongBits(other.averageRating)
        && Objects.equals(publishingYear, other.publishingYear)
        && Objects.equals(title, other.title)
        && Objects.equals(videoGameSystem, other.videoGameSystem);
  }

}
