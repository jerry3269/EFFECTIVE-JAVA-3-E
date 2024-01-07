package chapter2.item5;

public class Zoo_SingleTon {
    private final Animal animal;
    private Zoo_SingleTon(Animal animal) {
        this.animal = animal;
    }
    public static Zoo_SingleTon INSTANCE = new Zoo_SingleTon(new Lion());

    public boolean hasStripe() {
        return INSTANCE.animal.hasStripe();
    }

    public Animal getAnimal() {
        return animal;
    }
}
