package chapter2.item1;

public abstract class Person {
    private String name;
    private int age;

    public static Person from(Person person) {
        return person;
    }
}

