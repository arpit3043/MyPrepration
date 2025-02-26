package Heaps;
import java.util.Collections;
import java.util.PriorityQueue;
public class KthSmallestElementInMatrix {
    public static void main(String[] args) {
        int N = 4;
        int[][] mat = {
                {16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94 }
        };
        int K = 3;
        System.out.println(kthSmallestElement(mat, N, K));
    }
    private static int kthSmallestElement(int[][] mat, int n, int k) {
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(priorityQueue.size()==k) {
                    if (mat[i][j] >= priorityQueue.peek()) {
                        continue;
                    }
                    priorityQueue.poll();
                    priorityQueue.add(mat[i][j]);
                } else {
                    priorityQueue.add(mat[i][j]);
                }
            }
        }
        return priorityQueue.peek();
    }
}