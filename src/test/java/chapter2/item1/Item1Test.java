package chapter2.item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Item1Test {
    
    @DisplayName("정적 팩터리 메서드는 이름을 가질 수 있고, 호출마다 새로운 인스턴스를 생성하지 않습니다.")
    @Test
    void singleTon(){
        //given
        MemberSingleTon instance1 = MemberSingleTon.getInstance();
        MemberSingleTon instance2 = MemberSingleTon.getInstance();

        //then
        assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("반환 타입의 하위 타입 객체를 반환 할 수 있습니다.")
    @Test
    void canReturnsSubType(){
        //given
        MemberSingleTon memberSingleTon = MemberSingleTon.getInstance();
        Person person = Person.from(memberSingleTon);

        //then
        assertThat(person).isInstanceOf(Person.class);
    }


    @DisplayName("하위타입이기만 하면 입력매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.")
    @Test
    void canReturnsSubTypes(){
        //given
        MemberSingleTon memberSingleTon = MemberSingleTon.getInstance();
        AdminSingleTon adminSingleTon = AdminSingleTon.getInstance();
        Person personFromMember = Person.from(memberSingleTon);
        Person personFromAdmin = Person.from(adminSingleTon);

        //then
        assertThat(personFromMember).isExactlyInstanceOf(MemberSingleTon.class);
        assertThat(personFromAdmin).isExactlyInstanceOf(AdminSingleTon.class);
    }
}