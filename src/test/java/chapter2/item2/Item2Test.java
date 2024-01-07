package chapter2.item2;


import chapter2.item2.hierarchicalbuilder.Calzone;
import chapter2.item2.hierarchicalbuilder.NyPizza;
import chapter2.item2.hierarchicalbuilder.Pizza;
import chapter2.item2.telescopingconstructor.NutritionFacts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Item2Test {

    @DisplayName("점층적 생성자 패턴은 매개변수가 많아 질수록 코드를 작성하거나 읽기 어려워 집니다.")
    @Test
    void telescopingconstructor() {
        //given
        NutritionFacts nutritionFacts = new NutritionFacts(1, 2, 3, 4, 5, 6);

        //then
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servingSize", 1);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servings", 2);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("calories", 3);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("fat", 4);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("sodium", 5);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("carbohydrate", 6);
    }

    @DisplayName("자바빈즈 패턴은 객체를 불변으로 생성할 수 없고, 매개변수 값을 설정하기 위해 여러 메서드를 호출해야 합니다.")
    @Test
    void javaBeans() {
        //given
        chapter2.item2.javabeans.NutritionFacts nutritionFacts = new chapter2.item2.javabeans.NutritionFacts();

        nutritionFacts.setServingSize(1);
        nutritionFacts.setServings(2);
        nutritionFacts.setCalories(3);
        nutritionFacts.setFat(4);
        nutritionFacts.setSodium(5);
        nutritionFacts.setCarbohydrate(6);

        //then
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servingSize", 1);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servings", 2);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("calories", 3);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("fat", 4);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("sodium", 5);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("carbohydrate", 6);
    }

    @DisplayName("빌더패턴은 메서드 체인 형식을 제공하여 유연한 생성자를 제공합니다.")
    @Test
    void builder() {
        //given
        chapter2.item2.builder.NutritionFacts nutritionFacts = new chapter2.item2.builder.NutritionFacts.Builder(1, 2)
                .calories(3)
                .fat(4)
                .sodium(5)
                .carbohydrate(6)
                .build();

        //then
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servingSize", 1);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("servings", 2);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("calories", 3);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("fat", 4);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("sodium", 5);
        assertThat(nutritionFacts).hasFieldOrPropertyWithValue("carbohydrate", 6);
    }

    @DisplayName("빌더패턴은 계층적으로 설계된 클래스에서 사용하기 좋습니다.")
    @Test
    void hierarchicalbuilder(){
        //given
        NyPizza nyPizza = new NyPizza
                .Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.PEPPER)
                .build();

        //then
        assertThat(nyPizza).hasFieldOrPropertyWithValue("size", NyPizza.Size.MEDIUM);
        assertThat(nyPizza.getToppings()).hasSize(2);
        assertThat(calzone.getToppings()).hasSize(1);
    }
}
