// Calculate number of binary subarrays(Contigious) whose OR is Zero
// Total number of subarrays: N(N+1)/2
package OR;

public class NumberOfSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1, 0, 1, 0, 0};
        System.out.println("Number of subarrays with OR = 0: " + numberOfSubArrays(arr));
    }

    private static int numberOfSubArrays(int[] array) {
        int n = array.length;
        int count = 0;
        int zeroCount = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] == 0) {
                zeroCount++;
            } else {
                count += (zeroCount * (zeroCount + 1)) / 2;
                zeroCount = 0;
            }
        }
        count = count + (zeroCount *(zeroCount + 1))/2;
        return count;
    }
}
