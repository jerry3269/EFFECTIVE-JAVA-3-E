package chapter4.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentedSetTest {
    
    @DisplayName("컴포지션과 전달방식 : 래퍼 클래스를 사용하여 상속의 문제점을 해결할 수 있습니다. ")
    @Test
    void test1(){
        //given
        InstrumentedSet<String> hashSet = new InstrumentedSet<>(new HashSet<String>());
        hashSet.addAll(List.of("1", "2", "3"));

        //then
        assertThat(hashSet.getAddCount()).isEqualTo(3);
    }

    @DisplayName("컴포지션과 전달 방식을 사용하면 여러 구현 클래스마다 따로 확장할 필요가 없습니다.")
    @Test
    void test2(){
        //given
        InstrumentedSet<String> hashSet = new InstrumentedSet<>(new HashSet<>());
        hashSet.addAll(List.of("1", "2", "3"));

        InstrumentedSet<String> treeSet = new InstrumentedSet<>(new TreeSet<>());
        treeSet.addAll(List.of("1", "2", "3"));

        //then
        assertThat(hashSet.getAddCount()).isEqualTo(3);
        assertThat(treeSet.getAddCount()).isEqualTo(3);
    }
}
