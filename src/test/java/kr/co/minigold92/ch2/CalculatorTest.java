package kr.co.minigold92.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
//    JUnit은 TEST 애너테이션을 붙인 메서드를 테스트 메서드로 인식한다.
    @Test
    void plus(){
        Assertions.assertEquals(3, Calculator.plus(1, 2));
        Assertions.assertEquals(5, Calculator.plus(4, 1));
    }
}
