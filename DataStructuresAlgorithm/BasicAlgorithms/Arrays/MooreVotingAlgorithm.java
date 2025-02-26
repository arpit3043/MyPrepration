package BasicAlgorithms.Arrays;
public class MooreVotingAlgorithm {
    public static void main(String[] args) throws Exception {
        int[] arr = {2,2,1,3,1,1,3,1,1};
        System.out.println(mooreAlgorithmForMoreThanHalf(arr));
    }
    private static int mooreAlgorithmForMoreThanHalf(int[] arr) {
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