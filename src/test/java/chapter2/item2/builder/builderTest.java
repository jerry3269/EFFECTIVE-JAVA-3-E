package chapter2.item2.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class builderTest {

    @DisplayName("빌더패턴은 메서드 체인 형식을 제공하여 유연한 생성자를 제공합니다.")
    @Test
    void builder() {
        //given
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1, 2)
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
}