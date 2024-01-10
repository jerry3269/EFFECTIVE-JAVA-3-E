package chapter3.item10;

import chapter3.item10.inheritance.ColorPoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Item10Test {

    @DisplayName("동치관계의 대칭성에 위배되면 한 반향으로만 equals가 동작합니다.")
    @Test
    void symmetry(){
        //given
        CaseInsensitiveString cis1 = new CaseInsensitiveString("hello");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("hello");
        String string = "hello";

        //then
        assertThat(cis1.equals(cis2)).isTrue();
        assertThat(cis1.equals(string)).isTrue();
        assertThat(string.equals(cis1)).isFalse();
    }

    @DisplayName("새로운 필드를 추가한 하위클래스와 상위클래스를 비교할 때 새로운 필드를 무시하도록 설정하면 추이성에 어긋납니다.")
    @Test
    void transitivity(){
        //given
        Point point = new Point(1, 1);
        ColorPoint colorPoint1 = new ColorPoint(1, 1, Color.BLUE);
        ColorPoint colorPoint2 = new ColorPoint(1, 1, Color.RED);

        //then
        assertThat(point.equals(colorPoint1)).isTrue();
        assertThat(point.equals(colorPoint2)).isTrue();
        assertThat(colorPoint1.equals(colorPoint2)).isFalse();
    }
}