package chapter3.item11;

import java.util.Objects;

public class NoHashCode {
    //전화번호
    private short areaCode;
    private short prefix;
    private short lineNum;

    public NoHashCode(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoHashCode that)) return false;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

}
