package main;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
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
        .map(g -> g.title()) // .map(VideoGame::title)
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

    // filter, findAny/findFirst
    System.out.println("Ein Switch-Spiel");
    Optional<VideoGame> switchGame = games.stream()
        .filter(g -> g.videoGameSystem()
            .equals(VideoGameSystem.NSW))
        .findAny();
    switchGame.ifPresent(System.out::println);
    System.out.println();

    // anyMatch/allMatch/noneMatch
    System.out.println("Gibt es ein PS4-Spiel mit einer Durchschnittsbewertung < 7?");
    boolean exists = games.stream()
        // .anyMatch(g -> g.averageRating() < 7 && g.videoGameSystem().equals(VideoGameSystem.PS4));
        .filter(g -> g.averageRating() < 7)
        .anyMatch(g -> g.videoGameSystem()
            .equals(VideoGameSystem.PS4));
    System.out.println(exists);
    System.out.println();

    // map, distinct, toList
    System.out.println("Alle Konsolen als Liste");
    List<VideoGameSystem> videoGameSystems = games.stream()
        .map(g -> g.videoGameSystem())
        .distinct()
        .toList();
    videoGameSystems.forEach(System.out::println);
    System.out.println();

    // collect
    System.out.println("Alle Spiele nach Konsole gruppiert");
    Map<VideoGameSystem, List<VideoGame>> gamesByVideoGameSystem = games.stream()
        .collect(Collectors.groupingBy(g -> g.videoGameSystem()));
    gamesByVideoGameSystem.forEach((s, gs) -> System.out.println(s + ": " + gs));

  }

}
