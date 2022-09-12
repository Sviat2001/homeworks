package algorithms;

import java.util.Comparator;
import java.util.Random;

public class TestAlgorithms {

    public static void main(String[] args) {
        Person[] people = new Person[10];
        fillArray(people);
        printArray(people);
        HeapSort.sort(people, sortObjectSelection(-1));
        printArray(people);
        int resultOfSearch = LinearSearch.searchInAllArray(people);
        System.out.println("\n" + resultOfSearch + " - people has identical weight and unique height");
    }

    public static Comparator<Person> sortObjectSelection(int type) {
        Comparator<Person> personComparator = switch (type) {
            case 1 -> Comparator.comparing(person -> person.getHeight());
            case 2 -> Comparator.comparing(person -> person.getWeight());
            default -> Comparator.comparing(person -> person.getAge());
        };

        return personComparator;
    }

    private static void printArray(Person[] people) {
        System.out.println("\nArray: ");

        for(Person person : people) {
            System.out.println(person);
        }

        System.out.println("End");
    }

    private static void fillArray(Person[] people) {
        Random random = new Random();
        int height, weight, age;

        for(int i = 0; i < people.length; i++) {
            height = Math.abs(random.nextInt()) % 30 + 155;
            weight = Math.abs(random.nextInt()) % 30 + 50;
            age = Math.abs(random.nextInt()) % 30 + 25;

            people[i] = new Person(height, weight, age);
        }
    }
}
