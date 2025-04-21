package Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] arr) {
        int N = arr.length;
        int frequency = 0;
        int element = 0;
        for (int i = 0; i < N; i++) {
            if (frequency == 0) {
                frequency = 1;
                element = arr[i];
            } else if (arr[i] == element) {
                frequency++;
            } else {
                frequency--;
            }
        }
        int count = 0;
        for (int i=0; i<N; i++) {
            if(arr[i] == element) {
                count++;
            }
        }
        if(count>N/2){
            return element;
        }
        return -1;
    }
}
