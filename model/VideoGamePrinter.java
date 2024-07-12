package model;

import java.util.function.Consumer;

/**
 * VideoGamePrinter
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class VideoGamePrinter implements Consumer<VideoGame> {

  @Override
  public void accept(VideoGame videoGame) {
    System.out.println(videoGame);
  }

}
