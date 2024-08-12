package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.List;
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

  @BeforeEach
  void setUp() {
    shop = new Shop<>("MyShop", new HashMap<>());
    p1 = new ProductStub(1);
  }

  @Test
  void testAddProduct() {
    shop.addProduct(p1);
    assertTrue(shop.assortment()
        .containsKey(p1));
    assertTrue(shop.assortment()
        .get(p1) != null);
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

  }

  @Test
  void testAddRating3() {

  }

}
