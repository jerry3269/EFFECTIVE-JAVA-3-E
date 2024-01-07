package chapter2.item4;

import chapter2.item4.abstracts.Member;
import chapter2.item4.abstracts.Person;
import chapter2.item4.privateConstructor.UtilityClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Item4Test {

    @DisplayName("추상클래스는 하위클래스를 통한 인스턴스화를 방지하지 못합니다.")
    @Test
    void abstractInstance(){
        //given
        Person person = new Member();

        //then
        assertThat(person).isInstanceOf(Person.class);
    }

    @DisplayName(
            "private 생성자는 외부에서의 호출을 막아 인스턴스화를 방지합니다. " +
            "내부에서도 실수로 생성자를 호출하게 될경우 인스턴스화를 방지하기 위해 예외를 발생시킵니다.")
    @Test
    void callPrivateConstructor() {
        //given & then
        assertThrows(AssertionError.class, UtilityClass::callConstructor);
    }

}