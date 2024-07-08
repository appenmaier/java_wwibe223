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
    // Double averageRating1 = videoGame1.getAverageRating();
    // Double averageRating2 = videoGame2.getAverageRating();
    //
    // return averageRating2.compareTo(averageRating1);
    return Double.valueOf(videoGame2.getAverageRating()).compareTo(videoGame1.getAverageRating());
  }

}
