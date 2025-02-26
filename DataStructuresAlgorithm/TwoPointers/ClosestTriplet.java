package TwoPointers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;
public class ClosestTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            arr.add(scanner.nextInt());
        }
        int result = countTriplets(arr, N, M);
        System.out.println(result);
        scanner.close();
    }
    private static int countTriplets(List<Integer> arr, int N, int M) {
        Collections.sort(arr);
        int count = 0;
        int i = 0;
        while (i < N) {
            int sameCount = 1;
            while (i + 1 < N && arr.get(i).equals(arr.get(i + 1))) {
                sameCount++;
                i++;
            }
            count += (sameCount / 3);
            int consecCount = 1;
            while (i + 1 < N && arr.get(i) + 1 == arr.get(i + 1)) {
                consecCount++;
                i++;
            }
            count += Math.min(consecCount, sameCount / 2);
            i++;
        }
        return count;
    }
}