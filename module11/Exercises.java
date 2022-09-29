package module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercises {

    private static String exercise_1(List<String> names) {
        StringBuilder result = new StringBuilder("");

        if(names.size() > 1) {
            result.append(1 + ". " + names.get(1));

            IntStream.range(3, names.size()).forEachOrdered(i -> {
                if(i % 2 == 1) result.append(", " + i + ". " + names.get(i));
            });
        }


        return result.toString();
    }

    private static List<String> exercise_2(List<String> names) {
        List<String> result = names.stream()
                .sorted(Collections.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return result;
    }



    private static void exercise_3(List<String> numbers) {
        List<String[]> resultStrings = numbers.stream()
                .map(number-> number.split(","))
                .collect(Collectors.toList());
        List<Integer> result = resultStrings.stream()
                .flatMapToInt(number -> Arrays.stream(number).
                        mapToInt(num -> Integer.parseInt(num.trim())))
                .sorted()
                .boxed()
                .toList();


        System.out.println("\nExercise 3 : \n" + result);
    }


    private static Stream<Long> exercise_4(long a, long c, long m) {
        LongStream result = LongStream.iterate(0, n -> (a * n + c) % m);
        return result.boxed();
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        Stream.Builder<T> builder = Stream.builder();

        int index = 0, size;

        if(firstList.size() > secondList.size()) {
            size = secondList.size();
        } else {
            size = firstList.size();
        }

        while(index < size) {
            builder.add(firstList.get(index))
                    .add(secondList.get(index));
            index++;
        }

        return builder.build();
    }



    public static void main(String[] args) {
        test();
    }

    private static void test() {
        List<String> names = List.of("SV0", "SV1", "SV2", "SV3", "SV4", "SV5");
        List<String> result = exercise_2(names);

        System.out.println("Exercise 1 :\n" + exercise_1(names) + "\n\nExercise 2 : ");
        result.forEach(System.out::println);

        exercise_3(List.of("1, 2, 3, 41", "2, 3, 4, 5"));

        System.out.println("\nExercise 5 : \n" + zip(names.stream(), names.stream()).collect(Collectors.toList()));
    }
}
