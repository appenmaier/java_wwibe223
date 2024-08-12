package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.InvalidRatingException;
import model.NoProductFoundException;
import model.Shop;

public class ShopTest {

  private static record ProductStub(int returnValue) implements Comparable<ProductStub> {

    @Override
    public int compareTo(ProductStub o) {
      return returnValue;
    }

  }

  Shop<ProductStub> shop;
  ProductStub p1;
  ProductStub p2;
  ProductStub p3;

  @BeforeEach
  void setUp() {
    shop = new Shop<>("MyShop", new HashMap<>());
    p1 = new ProductStub(1);
    p2 = new ProductStub(2);
    p3 = new ProductStub(3);
  }

  @Test
  void testAddProduct() {
    shop.addProduct(p1);
    assertTrue(shop.assortment()
        .containsKey(p1));
    assertNotNull(shop.assortment()
        .get(p1));
  }

  @Test
  void testAddRating1() throws NoProductFoundException, InvalidRatingException {
    shop.addProduct(p1);
    shop.addRating(p1, 1);
    shop.addRating(p1, 3);
    List<Integer> ratings = shop.assortment()
        .get(p1);
    assertEquals(2, ratings.size());
    assertEquals(1, ratings.get(0));
    assertEquals(3, ratings.get(1));
  }

  @Test
  void testAddRating2() {
    assertThrows(NoProductFoundException.class, () -> shop.addRating(p1, 1));
  }

  @Test
  void testAddRating3() {
    shop.addProduct(p1);
    assertThrows(InvalidRatingException.class, () -> shop.addRating(p1, 0));
    assertThrows(InvalidRatingException.class, () -> shop.addRating(p1, 6));
  }

  @Test
  void testGetAllProductsSortedByNaturalOrdering1() {
    assertEquals(0, shop.getAllProductsSortedByNaturalOrdering()
        .size());
  }

  @Test
  void testGetAllProductsSortedByNaturalOrdering2() {
    shop.addProduct(p3);
    shop.addProduct(p1);
    shop.addProduct(p2);
    List<ProductStub> products = shop.getAllProductsSortedByNaturalOrdering();
    assertEquals(3, products.size());
    assertEquals(p1, products.get(0));
    assertEquals(p2, products.get(1));
    assertEquals(p3, products.get(2));
  }

  @Test
  void testGetBestRatedProduct1() {
    assertEquals(Optional.empty(), shop.getBestRatedProduct());
  }

  @Test
  void testGetBestRatedProduct2() throws NoProductFoundException, InvalidRatingException {
    shop.addProduct(p1);
    shop.addProduct(p2);
    shop.addRating(p1, 4);
    shop.addRating(p2, 1);
    shop.addRating(p2, 5);
    assertEquals(Optional.of(p1), shop.getBestRatedProduct());
    assertEquals(p1, shop.getBestRatedProduct()
        .get());
  }

}
