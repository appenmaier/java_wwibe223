package main;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import model.VideoGame;
import model.VideoGameSystem;

/**
 * Java Stream API
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D11_JavaStreamAPI {

  public static void main(String[] args) {

    List<VideoGame> games = VideoGame.getVideoGames();
    games.forEach(System.out::println);
    System.out.println();

    // filter, map, toList
    System.out.println("Alle Titel aller PS4-Spiele als Liste");
    List<String> names = games.stream()
        .filter(g -> g.videoGameSystem()
            .equals(VideoGameSystem.PS4))
        .map(v -> v.title()) // .map(VideoGame::title)
        .toList();
    names.forEach(System.out::println);
    System.out.println();

    // mapToDouble/mapToInt/mapToLong, average/sum
    System.out.println("Die Durchschnittsbewertung aller Spiele als Optional");
    OptionalDouble averageRating = games.stream()
        .mapToDouble(g -> g.averageRating()) // .map(VideoGame::averageRating)
        .average();
    averageRating.ifPresent(System.out::println);
    System.out.println();

    // sorted, limit/skip, forEach
    System.out.println("Die Top 3 Spiele ausgeben");
    games.stream()
        .sorted((g1, g2) -> Double.compare(g2.averageRating(), g1.averageRating()))
        .limit(3)
        .forEach(System.out::println);
    System.out.println();

    // max/min/count
    System.out.println("Das beste Spiel als Optional");
    Optional<VideoGame> bestGame = games.stream()
        .max((g1, g2) -> Double.compare(g1.averageRating(), g2.averageRating()));
    bestGame.ifPresent(System.out::println);
    System.out.println();

  }

}
