package Stacks;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
class Person {
    String name;
    int age;
    int number;
    public Person(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }
    @Override
    public String toString() {
        return "number = " + number + ", name = " + name + ", age = " + age;
    }
}

public class SeatingOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        int i = 0;

        try {
            while (sc.hasNext()) {
                String in = sc.nextLine().trim();
                String[] str = in.split(" ", 2);
                list.add(new Person(str[0], Integer.parseInt(str[1]), i++));
            }
            SeatingOrder solution = new SeatingOrder();
            solution.priority(list);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format for age.");
        } finally {
            sc.close();
        }
    }

    public void priority(List<Person> list) {
        PriorityQueue<Person> stack = new PriorityQueue<>(list.size(), new PersonComparator());
        stack.addAll(list);

        while (!stack.isEmpty()) {
            System.out.println(stack.poll().toString());
        }
    }

    public class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if ((p1.age < 5 || p1.age > 60) && (p2.age >= 5 && p2.age <= 60)) {
                return -1;
            }
            if ((p1.age >= 5 && p1.age <= 60) && (p2.age < 5 || p2.age > 60)) {
                return 1;
            }
            return p1.number - p2.number;
        }
    }
}