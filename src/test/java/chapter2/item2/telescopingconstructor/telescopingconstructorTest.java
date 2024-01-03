package chapter2.item2.telescopingconstructor;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class telescopingconstructorTest {

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

}