package chapter4.item17;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MutableItem17Test {
    
    @DisplayName("다단계 연산이 모두 예측이 가능한 연산이라면 가변 객체 클래스를 package-private으로 설정합니다.")
    @Test
    void test1(){
        //given
        MutableItem17 mutableItem17 = new MutableItem17(10, 20);
        mutableItem17.addPf1(10);
        mutableItem17.addPf2(20);
        Item17 item17 = mutableItem17.toItem17();

        assertThat(item17.getPf1()).isEqualTo(20);
        assertThat(item17.getPf2()).isEqualTo(40);
    }

    @DisplayName("가변 객체 클래스를 package-private으로 설정하면 외부 패키지에서는 접근할 수 없으므로 불변 객체에서만 사용합니다." +
            "오로지 불변 객체에서만 가변 객체 클래스를 사용하여 다단계 연산을 수행합니다.")
    @Test
    void test2(){
        //given
        Item17 item17 = Item17.addOperation(20);

        assertThat(item17.getPf1()).isEqualTo(30);
        assertThat(item17.getPf2()).isEqualTo(40);
    }
}
