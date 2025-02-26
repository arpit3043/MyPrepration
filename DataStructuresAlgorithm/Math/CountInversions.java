package Math;
public class CountInversions {
    public static void main(String[] args) throws Exception {
        int[] arr = { 9, 4, 3, 5, 1 };
        System.out.println("The inversion count is " + findInversionCount(arr));
    }
    private static int findInversionCount(int[] arr) {
        int N=arr.length;
        int inversionCount = 0;
        for (int j = 1; j < N - 1; j++) {
            int greater = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[j]) {
                    greater++;
                }
            }
            int smaller = 0;
            for (int k = j + 1; k < N; k++) {
                if (arr[k] < arr[j]) {
                    smaller++;
                }
            }
            inversionCount += (greater * smaller);
        }
        return inversionCount;
    }
}