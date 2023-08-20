package kr.co.minigold92.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.co.minigold92.ch2.PasswordStrength.*;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        assertEquals(expStr, meter.meter(password));
    }

    @Test
    @DisplayName("모두 통과하는 경우 ")
    void meetsAllCriterial_Then_Strong() {
        assertStrength("ab12!@AB", STRONG);
    }

    @Test
    @DisplayName("길이만 충족하지 않는 경우")
    void meetsOtherCriteria_for_Length_Then_Normal() {
        assertStrength("ab12!@A", NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건만 충족")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", NORMAL);
    }

    @Test
    @DisplayName("입력이 null인 경우")
    void nullInput_Then_Invalid() {
        assertStrength(null, INVALID);
    }

    @Test
    @DisplayName("입력이 빈 문자열인 경우")
    void emptyInput_Then_Invalid() {
        assertStrength("", INVALID);
    }
    @Test
    @DisplayName("대문자를 포함하는 조건만 충족하지 않는 경우")
    void meetsOtherCriteria_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", NORMAL);
    }
    @Test
    @DisplayName("길이 조건만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abcdefghijk", WEAK);
    }

    @Test
    @DisplayName("숫자 포함 조건만 충족하는 경우")
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("1234", WEAK);
    }

    @Test
    @DisplayName("대문자 포함 조건만 충족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("A", WEAK);
    }

    @Test
    @DisplayName("아무 조건도 충족하지 않은 경우")
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", WEAK);
    }
}
