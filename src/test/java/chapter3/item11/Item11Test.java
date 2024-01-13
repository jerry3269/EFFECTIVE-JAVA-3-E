package chapter3.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class Item11Test {

    @DisplayName("해시코드가 존재하지 않는다면 논리적 동치인 두 객체의 해시코드 값이 다른 값이 나옵니다.")
    @Test
    void NoHashCode1() {
        //given
        NoHashCode noHashCode1 = new NoHashCode((short) 010, (short) 1234, (short) 5678);
        NoHashCode noHashCode2 = new NoHashCode((short) 010, (short) 1234, (short) 5678);

        //then
        assertThat(noHashCode1).isEqualTo(noHashCode2);
        assertThat(noHashCode1.hashCode()).isNotEqualTo(noHashCode2);
    }

    @DisplayName("해시코드가 존재하지 않는다면 논리적 동치인 두 객체가 Set에 중복되어 들어갑니다.")
    @Test
    void NoHashCode2() {
        //given
        HashSet<Object> set = new HashSet<>();
        NoHashCode noHashCode1 = new NoHashCode((short) 010, (short) 1234, (short) 5678);
        NoHashCode noHashCode2 = new NoHashCode((short) 010, (short) 1234, (short) 5678);
        set.add(noHashCode1);
        set.add(noHashCode2);

        //then
        assertThat(set.size()).isEqualTo(2);
    }

    @DisplayName("컬렉션에서 해시코드가 같아야 equals를 비교하여 객체를 찾는다. 해시코드가 다르면 equals 조차 실행하지 않늗다.")
    @Test
    void NoHashCode3() {

        //given
        HashMap<NoHashCode, String> map = new HashMap<>();
        NoHashCode noHashCode1 = new NoHashCode((short) 010, (short) 1234, (short) 5678);
        map.put(noHashCode1, "jerry");

        NoHashCode noHashCode2 = new NoHashCode((short) 010, (short) 1234, (short) 5678);

        //when
        String result = map.get(noHashCode2);

        //then
        assertThat(noHashCode1).isEqualTo(noHashCode2);
        assertThat(result).isNull();
    }

    @DisplayName("전형적인 해시코드는 ObjectHashCode보다 성능면에서 뛰어납니다.")
    @Test
    void traditionalHashCode() {
        //given
        TraditionalHashCode traditionalHashCode = new TraditionalHashCode();
        ObjectHashCode objectHashCode = new ObjectHashCode();

        //when
        long traditionalStart = System.nanoTime();
        traditionalHashCode.hashCode();
        long traditionalEnd = System.nanoTime();
        double traditionalSeconds = (double) (traditionalEnd - traditionalStart) / 1_000_000_000;

        long objectStart = System.nanoTime();
        objectHashCode.hashCode();
        long objectEnd = System.nanoTime();
        double objectSeconds = (double) (objectEnd - objectStart) / 1_000_000_000;


        //then
        System.out.println("전형적인 해시태그 실행시간: " + traditionalSeconds + "초");
        System.out.println("Object 해시태그 실행시간: " + objectSeconds + "초");
        System.out.println("traditinoal/obects: " + objectSeconds/traditionalSeconds + "배");
        assertThat(traditionalSeconds).isLessThan(objectSeconds);
    }



}