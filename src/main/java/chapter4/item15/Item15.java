package chapter4.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item15 {
    public static final String[] publicString = {"hello"};
    private static final String[] privateString = {"hello"};
    public static final List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList(privateString));
    public static final String[] returnClone() {
        return privateString.clone();
    }
}
