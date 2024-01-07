package chapter2.item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Item5Test {
    
    @DisplayName("정적 유틸리티를 사용하여 자원을 명시하면, 여러 자원을 활용하지 못하여 유용하지 않습니다.")
    @Test
    void staticUtility(){
        //given
        boolean hasStripe = Zoo_StaticUtility.hasStripe();
        Animal animal = Zoo_StaticUtility.getAnimal();

        //then
        assertThat(hasStripe).isFalse();
        assertThat(animal).isExactlyInstanceOf(Lion.class);
    }

    @DisplayName("싱글톤을 사용하여 자원을 명시하면, 여러 자원을 활용하지 못하여 유용하지 않습니다.")
    @Test
    void singleTon(){
        //given
        Zoo_SingleTon instance = Zoo_SingleTon.INSTANCE;
        boolean hasStripe = instance.hasStripe();
        Animal animal = instance.getAnimal();

        //then
        assertThat(hasStripe).isFalse();
        assertThat(animal).isExactlyInstanceOf(Lion.class);
    }


    @DisplayName("DI를 사용하면 여러 자원을 활용하여 자원할당이 가능합니다. 할당받은 자원은 불변을 유지합니다.")
    @Test
    void DependencyInjection(){
        //given
        Zoo_DependencyInjection zooInLion = new Zoo_DependencyInjection(new Lion());
        Zoo_DependencyInjection zooInTiger = new Zoo_DependencyInjection(new Tiger());

        //then
        assertThat(zooInLion.hasStripe()).isFalse();
        assertThat(zooInTiger.hasStripe()).isTrue();
        assertThat(zooInLion.getAnimal()).isExactlyInstanceOf(Lion.class);
        assertThat(zooInTiger.getAnimal()).isExactlyInstanceOf(Tiger.class);
    }
}