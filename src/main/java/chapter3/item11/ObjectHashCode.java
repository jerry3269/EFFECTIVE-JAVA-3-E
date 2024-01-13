package chapter3.item11;

import java.util.Objects;

public class ObjectHashCode {
    //전화번호
    private short areaCode;
    private short prefix;
    private short lineNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectHashCode that)) return false;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
