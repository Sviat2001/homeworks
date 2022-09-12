package algorithms;


import java.util.ArrayList;

public class LinearSearch { //O(n^2)

    public static int searchInAllArray(Person[] people) {
        int result = 0;

        for(Person person : people) {
            result += search(people, person.getWeight()) - 1;
        }

        return result;
    }

    public static int search(Person[] people, int weightValue) {
        int result = 0;
        ArrayList<Integer> personHeightList = new ArrayList<>();

        for(Person person : people) {
            if(person.getWeight() == weightValue) {
                int height = person.getHeight();

                if(!personHeightList.contains(height)) {
                    personHeightList.add(height);
                    result++;
                }
            }
        }

        return result;
    }
}
