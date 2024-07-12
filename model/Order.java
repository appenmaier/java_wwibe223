package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Bestellung
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class Order {

  private List<OrderItem> items;

  public Order() {
    items = new LinkedList<>();
  }

  public void addOrderItem(String description) {
    OrderItem orderItem = new OrderItem(description);
    items.add(orderItem);
  }

  public void addOrderItem(OrderItem orderItem) {
    items.add(orderItem);
  }

  public List<OrderItem> items() {
    return items;
  }

  /**
   * Bestellposition
   *
   * @author Daniel Appenmaier
   * @version 1.0
   *
   */
  public class OrderItem {

    private final String description;

    public OrderItem(String description) {
      this.description = description;
    }

    public String description() {
      return description;
    }

  }

}
