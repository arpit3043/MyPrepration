package Generics;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        pair<String, Integer> p = new pair<>();
        // It will accept all types of data as it is of Object type
        // However, it will give a run-time error at the time of execution
        // It may not sync directly with it; we have to wait for run-time
        // Object becomes a more general way for a data type
        p.setX("10");
        HashMap<Object, Object> h = new HashMap<>();
        h.put("val", 10);
        h.put(10, "10");
        pair.doSomething("abc", 10.00);
        System.out.println("Debug");
        /*
         * Making a HashMap of <Integer, String> type
         * However, when we insert the above two lines, we will not get an error
         * even during run-time and during compile-time as well
         * */
        // Raw Data-type
        // Prone to run-time error
        pair<Object, Object> p1 = new pair<>();
        p1.setY("abc");
        p1.setX(01);
    }
}
