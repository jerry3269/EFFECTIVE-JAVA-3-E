package chapter2.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Item7Test {

    @DisplayName("스택에서 pop()을 통해 객체를 더 이상 사용하지 않아도 가비지 컬렉터가 인식하지 못하여 회수하지 않습니다.")
    @Test
    void stackPopWrong() {
        //given
        Stack stack = new Stack();

        //when
        stack.push(new String("string1"));
        stack.push(new String("string2"));
        Object o = stack.pop_wrong();

        //then
        assertThat(stack.getElements()[1]).isExactlyInstanceOf(String.class);
    }

    @DisplayName("스택에서 pop()을 하여 참조를 다 쓴 상태일 경우 null처리를 하게되면 가비지 컬렉터가 해당 객체를 회수합니다.")
    @Test
    void stackPopRight() {
        //given
        Stack stack = new Stack();

        //when
        stack.push(new String("string1"));
        stack.push(new String("string2"));
        Object o = stack.pop_right();

        //then
        assertThat(stack.getElements()[1]).isNull();
    }
}
