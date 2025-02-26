package LamdasAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        // Populate the list with integers from 0 to 14
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }

        // Using streams in a single line to print each element
        list.stream().forEach(element -> System.out.println(element));

        // Create a list of strings
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // Intermediate operation: filter to keep only strings starting with "a"
        Stream<String> filteredStream = strings.stream().filter(s -> s.startsWith("a"));

        // Intermediate operation: map each string to uppercase
        Stream<String> mappedStream = filteredStream.map(String::toUpperCase);

        // Terminal operation: print each string
        mappedStream.forEach(System.out::println);

        // New Stream to filter and print all even data
        Stream<Integer> stream2 = list.stream();
        stream2.filter((element) -> {
            System.out.println("Filtering: " + element);
            return element % 2 == 0; // Check if the element is even
        }).forEach((element) -> System.out.println("Printing: " + element)); // Print the filtered even elements

        // Stream3 operations: filtering, sorting, and printing even numbers
        Stream<Integer> stream3 = list.stream();
        stream3.filter((element) -> {
            System.out.println("Filtering Stream3 " + element);
            return element % 2 == 0; // Check if the element is even
        }).sorted((object1, object2) -> {
            System.out.println("Sorting the Stream3: ");
            // Sorting the elements in ascending order
            if (object1 < object2) {
                return -1;
            } else if (object1 > object2) {
                return 1;
            }
            return 0;
        }).forEach(System.out::println); // Print the sorted even elements

        // Maps in Streams: filter, sort, map, and print even numbers with additional string
        Stream<Integer> stream4 = list.stream();
        System.out.println("Map Working in streams");
        stream4.filter((element) -> {
                    System.out.println("Filtering stream4: " + element);
                    return element % 2 == 0; // Check if the element is even
                }).sorted() // Sort the even elements
                .map((element) -> {
                    System.out.println("Mapping stream4: " + element);
                    return element + "Hi"; // Append "Hi" to each even element
                }).forEach((element) -> {
                    System.out.println("Elements are stream4: " + element); // Print the mapped elements
                });

        // Collect in Streams: filter, map, and collect even numbers as strings in a list
        Stream<Integer> stream5 = list.stream();
        System.out.println("Collect Working in streams");
        List<String> ans = stream5.filter((element) -> {
            System.out.println("Filtering stream4: " + element);
            return element % 2 == 0; // Check if the element is even
        }).map((element) -> element + " Hi").collect(Collectors.toList()); // Collect even elements as strings in a list
        for (String val : ans) {
            System.out.println("Printing stream5 " + val); // Print the collected elements
        }

        // IsPresent Method: filter, map, and find the first even number as a string
        Stream<Integer> stream6 = list.stream();
        Optional<String> ans2 = stream6.filter((element) -> {
            System.out.println("Filtering stream6: " + element);
            return element % 2 == 0; // Check if the element is even
        }).map((element) -> element + " Hi").findFirst(); // Find the first even element and append "Hi"
        if (ans2.isPresent()) {
            System.out.println(ans2.get()); // Print the first even element
        }

        // Reducing operation: Find the maximum even number using reduce
        Stream<Integer> stream7 = list.stream();
        int value = stream7.filter((ele) -> {
            System.out.println("Filtering the stream7 " + ele);
            return ele % 2 == 0; // Check if the element is even
        }).reduce(Integer.MIN_VALUE, (max_till_now, val2) -> Math.max(max_till_now, val2)); // Reduce operation to find the maximum even number
        System.out.println("Reduced value is: " + value);

        // Reduce with orElse Function
        Stream<Integer> stream8 = list.stream();
        Integer val = stream8.filter((ele) -> {
            System.out.println("Filtering the stream8 " + ele);
            return ele % 2 == 0; // Check if the element is even
        }).reduce((num1, num2) -> num1*num2).orElse(-1); // Reduce operation to find the maximum even number
        System.out.println("Reduced value is: " + val);
    }
}