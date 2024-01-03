package chapter2.item3.enumtype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SingleTonTest {

    @DisplayName("원소가 하나일 경우 열거형 타입의 싱글톤을 사용합니다. 싱글톤이기에 항상 같은 인스턴스를 반환합니다.")
    @Test
    void enumTypeSingleTon(){
        //given
        Elvis instance1 = Elvis.INSTANCE;
        Elvis instance2 = Elvis.INSTANCE;

        //then
        Assertions.assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("public static final 방식의 싱글톤은 항상 같은 인스턴스를 반환합니다.")
    @Test
    void publicTypeSingleTon() {
        //given
        chapter2.item3.field.Elvis instance1 = chapter2.item3.field.Elvis.INSTANCE;
        chapter2.item3.field.Elvis instance2 = chapter2.item3.field.Elvis.INSTANCE;

        //then
        Assertions.assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("정적 팩토리 방식의 싱글톤은 항상 같은 인스턴스를 반환합니다.")
    @Test
    void staticFactorySingleTon() {
        //given
        chapter2.item3.staticfactory.Elvis instance1 = chapter2.item3.staticfactory.Elvis.getInstance();
        chapter2.item3.staticfactory.Elvis instance2 = chapter2.item3.staticfactory.Elvis.getInstance();

        //then
        Assertions.assertThat(instance1).isEqualTo(instance2);
    }
}