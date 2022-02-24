package modernjavainaction.chap04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {

  public static void main(String... args) {
    // 자바 7
    getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

    System.out.println("---");

    // 자바 8
    getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
  }

  public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish d : dishes) {
      if (d.getCalories() < 400) {
        lowCaloricDishes.add(d);
      }
    }
    lowCaloricDishes.stream()
            .filter(d->d.getName().equals("test"))
            .forEach(System.out::println);

    List<String> lowCaloricDishesName = new ArrayList<>();
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
      @Override
      public int compare(Dish d1, Dish d2) {
        return Integer.compare(d1.getCalories(), d2.getCalories());
      }
    });
    for (Dish d : lowCaloricDishes) {
      lowCaloricDishesName.add(d.getName());
    }
    return lowCaloricDishesName;
  }

  public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {

    return dishes.parallelStream()
        .filter(d -> d.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(toList());
  }

}
