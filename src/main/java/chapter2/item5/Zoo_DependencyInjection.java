package chapter2.item5;

public class Zoo_DependencyInjection {
    private final Animal animal;

    public Zoo_DependencyInjection(Animal animal) {
        this.animal = animal;
    }

    public boolean hasStripe() {
        return animal.hasStripe();
    }

    public Animal getAnimal() {
        return animal;
    }
}
