package BinarySearchTree;
public class searchInsertedPosition {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,3,5,6};
        int target = 2;
        int N = arr.length;
        System.out.println(searchInsertedPositionInteger(arr, N, target));
    }
    private static int searchInsertedPositionInteger(int[] arr, int N, int target) {
        int start = 0;
        int end = N-1;
        int mid = start+(end-start)/2;
        while(start<end) {
            if (arr[start] == mid) {
                return mid;
            }
            else if(arr[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
            mid = start+(end-start)/2;
        }
        return end+1;
    }
}