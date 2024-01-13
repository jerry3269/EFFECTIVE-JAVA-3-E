package chapter3.item11;

import java.util.Objects;

public class TraditionalHashCode {
    //전화번호
    private short areaCode;
    private short prefix;
    private short lineNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraditionalHashCode that)) return false;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
