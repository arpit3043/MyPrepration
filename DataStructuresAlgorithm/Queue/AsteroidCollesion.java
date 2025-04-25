package DataStructuresAlgorithm.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollesion {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer>deque = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(asteroids[i]>0) {
                deque.offerLast(asteroids[i]);
            } else {
                while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < (-1)*asteroids[i]) {
                    deque.pollLast();
                }

                if (!deque.isEmpty() && deque.peekLast() == (-1)*asteroids[i]) {
                    deque.pollLast();
                }
                else if(deque.isEmpty() || deque.peekLast() < 0) {
                    deque.offerLast(asteroids[i]);
                }
            }
        }

        int[] result =  new int[deque.size()];
        int i=0;
        for(int num: deque) {
            result[i] = num;
            i++;
        }
        return result;
    }
}
