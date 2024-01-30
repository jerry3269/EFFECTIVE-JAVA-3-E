package chapter4.item15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Item15Test {

    @DisplayName("길이가 0이 아닌 배열은 모두 변경이 가능하니 주의해야 합니다.")
    @Test
    void test1(){
        //given
        String[] publicString1 = Item15.publicString;
        publicString1[0] = "변경했지롱~";
        String[] publicString2 = Item15.publicString;

        //then
        assertThat(publicString1[0]).isEqualTo("변경했지롱~");
        assertThat(publicString2[0]).isEqualTo("변경했지롱~");
    }

    @DisplayName("배열을 private으로 설정하고 public 불변리스트를 추가하면 배열의 변경을 막을 수 있습니다.")
    @Test
    void test2() {
        //given
        List<String> unmodifiableList = Item15.unmodifiableList;

        //then
        assertThatThrownBy(() -> unmodifiableList.set(0, "변경했지롱~"))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    @DisplayName("배열을 private으로 설정하고 clone을 반환하는 public 메서드를 추가하면 방어적 복사를 할 수 있습니다.")
    @Test
    void test3() {
        //given
        String[] strings1 = Item15.returnClone();
        strings1[0] = "변경했지롱~";
        String[] strings2 = Item15.returnClone();

        //then
        assertThat(strings1[0]).isEqualTo("변경했지롱~");
        assertThat(strings2[0]).isEqualTo("hello");
    }

}