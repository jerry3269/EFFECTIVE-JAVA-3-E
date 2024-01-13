package chapter3.item11;

public class LazyInitializationHashCode {
    //전화번호
    private short areaCode;
    private short prefix;
    private short lineNum;
    private int hashCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LazyInitializationHashCode that)) return false;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
}
