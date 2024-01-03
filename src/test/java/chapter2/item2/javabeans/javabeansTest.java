package chapter2.item2.javabeans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class javabeansTest {

    @DisplayName("자바빈즈 패턴은 객체를 불변으로 생성할 수 없고, 매개변수 값을 설정하기 위해 여러 메서드를 호출해야 합니다.")
    @Test
    void javaBeans() {
        //given
        NutritionFacts nutritionFacts = new NutritionFacts();

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

}