package algorithms;


import java.util.ArrayList;

public class LinearSearch {

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
        ArrayList<Boolean> personHeightQuantityList = new ArrayList<>();

        for(Person person : people) {
            if(person.getWeight() == weightValue) {
                int height = person.getHeight();

                if(!personHeightList.contains(height)) {
                    personHeightQuantityList.add(true);
                    personHeightList.add(height);
                    result++;
                } else if(personHeightQuantityList.get(personHeightList.indexOf(height))) {
                    personHeightQuantityList.set(personHeightList.indexOf(height), false);
                    result--;
                }
            }
        }

        return result;
    }
}
