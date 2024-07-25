package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Drache
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
@Data
@AllArgsConstructor
@Builder
public class DragonLombok {

  private final String name;
  private int age;

}
