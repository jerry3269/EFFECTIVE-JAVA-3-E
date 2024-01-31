package chapter4.item17;

import java.util.Objects;

public class Item17 {
    private final int pf1;
    private final int pf2;
    private int hash;

    private Item17(int pf1, int pf2) {
        this.pf1 = pf1;
        this.pf2 = pf2;
    }

    public static Item17 valueOf(int pf1, int pf2) {
        return new Item17(pf1, pf2);
    }

    public static Item17 addOperation(int num) {
        MutableItem17 mutableItem17 = new MutableItem17(10, 20);
        mutableItem17.addPf1(num);
        mutableItem17.addPf2(num);
        return new Item17(mutableItem17.getMutablePf1(), mutableItem17.getMutablePf2());
    }

    public int getPf1() {
        return pf1;
    }

    public int getPf2() {
        return pf2;
    }



    @Override
    public int hashCode() {
        int h = this.hash;
        if (h == 0) {
            hash = Objects.hash(pf1, pf2);
        }
        return hash;
    }
}
