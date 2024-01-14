package chapter3.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class Item14Test {

    @DisplayName("자바가 제공하는 비교자를 이용하여 객체를 비교합니다.")
    @Test
    void test1(){
        //given
        CaseInsensitiveString caseString1 = new CaseInsensitiveString("abcd");
        CaseInsensitiveString caseString2 = new CaseInsensitiveString("abcd");
        CaseInsensitiveString caseString3 = new CaseInsensitiveString("bcdf");

        //when
        int result1 = caseString1.compareTo(caseString2);
        int result2 = caseString1.compareTo(caseString3);
        int result3 = caseString3.compareTo(caseString1);

        //then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isLessThan(0);
        assertThat(result3).isGreaterThan(0);
    }


    /**
     * equals(caseString1, caseString2) == true         //equlas가 같다.
     * hashCode(caseString1) == hashCode(caseString2)
     * caseString1.compareTo(caseString2) != 0          //compareTo는 다르다.
     */
    @DisplayName("HashSet은 equals로, TreeSet은 compareTo로 동치성을 비교합니다.")
    @Test
    void test2(){
        //given
        CaseInsensitiveString caseString1 = new CaseInsensitiveString("abcd");
        CaseInsensitiveString caseString2 = new CaseInsensitiveString("ABCD");

        HashSet<CaseInsensitiveString> hashSet = new HashSet<>();
        TreeSet<CaseInsensitiveString> treeSet = new TreeSet<>();

        //when
        hashSet.add(caseString1);
        hashSet.add(caseString2);
        treeSet.add(caseString1);
        treeSet.add(caseString2);

        //then
        assertThat(hashSet.size()).isEqualTo(1);    //equals 및 hashCode가 같은 경우 중복이라고 판단
        assertThat(treeSet.size()).isEqualTo(2);    //compareTo가 다른 경우 중복이 아니라고 판단
    }

    @DisplayName("자바 8부터는 정수 기본 타입 필드도 관계 연산자가 아닌 정적 compare 메서드를 사용한다.")
    @Test
    void test3(){
        //given
        PhoneNumber phoneNumber1 = new PhoneNumber(010,123,4567);
        PhoneNumber phoneNumber2 = new PhoneNumber(010,123,4567);

        //when
        int result = phoneNumber1.compareTo(phoneNumber2);

        //then
        assertThat(result).isEqualTo(0);
    }


}