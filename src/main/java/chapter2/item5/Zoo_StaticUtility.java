package chapter2.item5;

public class Zoo_StaticUtility {
    private static final Animal animal = new Lion();

    private Zoo_StaticUtility() { //객체 생성 방지
    }

    public static boolean hasStripe() {
        return animal.hasStripe();
    }

    public static Animal getAnimal() {
        return animal;
    }
}
