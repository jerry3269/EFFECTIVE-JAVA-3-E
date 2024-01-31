package chapter4.item17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Item17Test {
    
    @DisplayName("불변 클래스에서 비용인 큰 인스턴스는 final이 아닌 필드로 선언하여 지연 초기화 할 수 있습니다.")
    @Test
    void test1() {
        //given
        Item17 item17 = Item17.valueOf(10, 20);
        int hash = item17.hashCode();

        //then
        assertThat(hash).isNotEqualTo(0);
    }

}