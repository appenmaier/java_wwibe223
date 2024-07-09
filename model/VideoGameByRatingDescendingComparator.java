package model;

import java.util.Comparator;

/**
 * VideoGameByRatingDescendingComparator
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class VideoGameByRatingDescendingComparator implements Comparator<VideoGame> {

  @Override
  public int compare(VideoGame videoGame1, VideoGame videoGame2) {
    // Double averageRating1 = videoGame1.averageRating();
    // Double averageRating2 = videoGame2.averageRating();
    //
    // return averageRating2.compareTo(averageRating1);
    return Double.valueOf(videoGame2.averageRating()).compareTo(videoGame1.averageRating());
  }

}
