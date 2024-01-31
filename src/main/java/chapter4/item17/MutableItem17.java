package chapter4.item17;

import java.util.Objects;

class MutableItem17 {
    private int mutablePf1;
    private int mutablePf2;

    public MutableItem17(int pf1, int pf2) {
        this.mutablePf1 = pf1;
        this.mutablePf2 = pf2;
    }

    public int getMutablePf1() {
        return mutablePf1;
    }

    public void setMutablePf1(int mutablePf1) {
        this.mutablePf1 = mutablePf1;
    }

    public int getMutablePf2() {
        return mutablePf2;
    }

    public void setMutablePf2(int mutablePf2) {
        this.mutablePf2 = mutablePf2;
    }

    public void addPf1(int num) {
        this.mutablePf1 += num;
    }

    public void addPf2(int num) {
        this.mutablePf2 += num;
    }

    public Item17 toItem17() {
        return Item17.valueOf(this.mutablePf1, this.mutablePf2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mutablePf1, mutablePf2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MutableItem17 other = (MutableItem17) obj;
        return mutablePf1 == other.mutablePf1 && mutablePf2 == other.mutablePf2;
    }

    @Override
    public String toString() {
        return "MutableItem17{" +
                "mutablePf1=" + mutablePf1 +
                ", mutablePf2=" + mutablePf2 +
                '}';
    }
}