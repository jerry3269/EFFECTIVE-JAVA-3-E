package chapter2.item2.hierarchicalbuilder;

import net.bytebuddy.implementation.bytecode.StackManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class hierarchicalbuilderTest {

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
        assertThat(nyPizza.toppings).hasSize(2);

        assertThat(calzone.toppings).hasSize(1);
    }

}