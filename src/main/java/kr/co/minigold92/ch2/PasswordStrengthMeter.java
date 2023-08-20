package kr.co.minigold92.ch2;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCnt = getMetCnt(s);
        if (metCnt <= 1) return PasswordStrength.WEAK;
        if (metCnt == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCnt(String s) {
        int metCnt = 0;
        if (s.length() >= 8) metCnt++;
        if (meetsContainingNumberCriteria(s)) metCnt++;
        if (meetsContainingUppercaseCriterial(s)) metCnt++;
        return metCnt;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriterial(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

}
