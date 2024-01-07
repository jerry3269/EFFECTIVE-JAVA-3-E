package chapter2.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item6Test {

    @DisplayName("생성 비용이 비싼 객체를 반복적으로 생성하는 경우 성능에 문제가 발생합니다. - 평균 50 마이크로 초")
    @Test
    void romanNumeralSlow(){
        //then
        RomanNumerals.main(new String[]{"3", "5", "0"}); //args[2]의 값이 짝수(0포함) 이면 SLow 실행
    }

    @DisplayName("생성 비용이 비싼 객체를 재사용하는 경우 경우 성능이 개선됩니다. - 평균 15 마이크로 초")
    @Test
    void romanNumeralFlow(){
        //then
        RomanNumerals.main(new String[]{"3", "5", "1"}); //args[2]의 값이 홀수 이면 Fast 실행
    }

    @DisplayName("오토박싱이 반복적으로 실행되는 경우 성능에 문제가 발생합니다. - 평균 4000 밀리 초")
    @Test
    void sumSlow(){
        //then
        Sum.main(new String[]{"1", "0"}); //args[1]의 값이 짝수(0포함) 이면 SLow 실행
    }

    @DisplayName("오토박싱을 사용하지 않고 기본타입을 사용하는 경우 성능이 개선됩니다. - 평균 500 마이크로 초")
    @Test
    void sumFast(){
        //then
        Sum.main(new String[]{"1", "1"}); //args[1]의 값이 홀수 이면 Fast 실행
    }
}
