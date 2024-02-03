package chapter4.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedHashSetTest {

    @DisplayName("상속은 상위 클래스의 구현에 따라 하위 클래스의 동작에 이상이 생길 수 있습니다. - 상속은 캡슐화를 깨뜨린다.")
    @Test
    void test(){
        //given
        InstrumentedHashSet<String> strings = new InstrumentedHashSet<>();
        strings.addAll(List.of("1", "2", "3"));

        //then
        assertThat(strings.getAddCount()).isEqualTo(6);
    }

}