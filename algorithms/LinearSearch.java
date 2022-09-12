package algorithms;


import java.util.ArrayList;

public class LinearSearch { //O(n^2)

    public static int search(Person[] people, int weightValue) {
        int result = 0;
        ArrayList<Integer> personHeightList = new ArrayList<>();
        ArrayList<Boolean> personHeightQuantityList = new ArrayList<>();

        for(Person person : people) {
            if(person.getWeight() == weightValue) {
                int height = person.getHeight();
                int heightIndex = personHeightList.indexOf(height);

                if(!personHeightList.contains(height)) {
                    personHeightQuantityList.add(true);
                    personHeightList.add(height);
                    result++;
                } else if(personHeightQuantityList.get(heightIndex)) {
                    personHeightQuantityList.set(heightIndex, false);
                    result--;
                }
            }
        }

        return result;
    }
}
