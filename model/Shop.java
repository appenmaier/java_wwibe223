package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * Shop
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record Shop<T extends Comparable<T>>(String name, Map<T, List<Integer>> assortment) { // 2 -
  // 2,5

  public void addProduct(T product) { // 0,5
    /* Variante A */
    if (!assortment.containsKey(product)) { // 1
      assortment.put(product, new ArrayList<>()); // 1
    }

    /* Variante B */
    // assortment.putIfAbsent(product, new ArrayList<>()); // 2

    /* Variante C (ungueltig) */
    // if (!assortment.containsKey(product)) { // 1
    // assortment.put(product, null); // 1
    // }
  } // 2,5

  public void addRating(T product, int rating)
      throws NoProductFoundException, InvalidRatingException { // 1 - 1,5
    if (assortment.containsKey(product) == false) { // 1
      throw new NoProductFoundException(); // 1
    }

    if (rating < 1 || rating > 5) { // 1
      throw new InvalidRatingException(rating); // 1 - 1,5
    }

    /* Variante A */
    List<Integer> ratings = assortment.get(product); // 1
    ratings.add(rating); // 0,5 - 1

    /* Variante B (ungueltig) */
    // if (ratings == null) {
    // assortment.put(product, new ArrayList<>()); // 1
    // }
    // ratings.add(rating); // 0,5 - 1
  } // 6,5 - 8

  public Optional<T> getBestRatedProduct() { // 0,5
    T bestRatedProduct = null; // 1
    // Optional<T> bestRatedProduct = Optional.empty(); // 1 - 1,5
    double bestAverageRating = 0; // 0,5

    for (Entry<T, List<Integer>> entry : assortment.entrySet()) { // 1
      T product = entry.getKey(); // 0,5 - 1
      List<Integer> ratings = entry.getValue(); // 0,5 - 1

      double totalRating = 0; // 0,5
      for (int rating : ratings) { // 1
        totalRating += rating; // 1
      }
      double averageRating = totalRating / ratings.size(); // 1 - 1,5

      if (averageRating > bestAverageRating) { // 1
        bestRatedProduct = product; // 0,5 - 1
        // bestRatedProduct = Optional.of(product); // 0,5 -1
        bestAverageRating = averageRating; // 0,5 - 1
      }
    }

    return Optional.ofNullable(bestRatedProduct); // 1 - 1,5
    // return bestRatedProduct; // 1
  } // 10,5 - 14

  public List<T> getAllProductsSortedByNaturalOrdering() { // 0,5
    List<T> allProducts = new ArrayList<>(); // 0,5
    for (T product : assortment.keySet()) { // 1
      allProducts.add(product); // 0,5 - 1
    }
    // List<T> allProducts = new ArrayList<>(assortment.keySet()); // 2 - 2,5

    Collections.sort(allProducts); // 1

    return allProducts; // 0,5
  } // 4 - 4,5

} // 2 - 2,5
// 23 - 29
