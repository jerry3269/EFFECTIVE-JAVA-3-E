package chapter3.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Item13Test {
    
    @DisplayName("가변 상태를 참조하지 않는 클래스용 clone 메서드")
    @Test
    void test1(){
        //given
        PhoneNumber phoneNumber = new PhoneNumber(010, 123, 5678);

        //when
        PhoneNumber clone = phoneNumber.clone();

        //then
        assertThat(phoneNumber).isNotEqualTo(clone);
        assertThat(phoneNumber.getAreaCode()).isEqualTo(clone.getAreaCode());
        assertThat(phoneNumber.getPrefix()).isEqualTo(clone.getPrefix());
        assertThat(phoneNumber.getLineNum()).isEqualTo(clone.getLineNum());
        assertThat(phoneNumber.getClass()).isEqualTo(clone.getClass());
    }

    @DisplayName("가변 상태를 참조하는 클래스용 clone 메서드")
    @Test
    void test2(){
        //given
        Stack stack = new Stack();


        //when
        Stack clone = stack.clone();

        //then
        assertThat(stack).isNotEqualTo(clone);
        assertThat(stack.getElements()).isNotSameAs(clone.getElements());
        assertThat(stack.getSize()).isEqualTo(clone.getSize());
    }

    @DisplayName("기본타입 배열일 경우에만 clone 메서드 복제가 가장 적합합니다.")
    @Test
    void test3(){
        //given
        int[] array = new int[10];


        //when
        int[] clone = array.clone();
        clone[1] = 10;

        //then
        assertThat(array).isNotEqualTo(clone);
        assertThat(array[1]).isNotEqualTo(10);
        assertThat(clone[1]).isEqualTo(10);
    }
}
