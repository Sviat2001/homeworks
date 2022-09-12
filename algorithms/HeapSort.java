package algorithms;

import java.util.Comparator;

public class HeapSort { //Time complexity: O(n * log(n))
    public static void sort(Person[] people, Comparator<Person> personComparator) {
        int n = people.length;
        
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, people, personComparator, n);
        }

        for(int i= n - 1; i >= 0; i--) {
            swap(people, 0, i);
            heapify(0, people, personComparator, i);
        }
    }


    private static void heapify(int parentIndex, Person[] people, Comparator<Person> personComparator, int n){
        Person parentElement = people[parentIndex];
        Person maxElement = parentElement;
        int maxElementIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;

        if(leftChild < n && personComparator.compare(people[leftChild], maxElement) > 0) {
            maxElement = people[leftChild];
            maxElementIndex = leftChild;
        }
        if(rightChild < n && personComparator.compare(people[rightChild], maxElement) > 0) {
            maxElementIndex = rightChild;
        }


        if(maxElementIndex != parentIndex) {
            swap(people, parentIndex, maxElementIndex);
            heapify(maxElementIndex, people, personComparator, n);
        }
    }

    private static void swap(Person[] people, int i, int j) {
        Person buffer = people[i];
        people[i] = people[j];
        people[j] = buffer;
    }

}
