package Arrays;
public class MedianOfTwoArrays {
    public static void main(String[] args) throws Exception {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};
        System.out.println(medianOfTwoSortedArrays(arr1, arr2));
    }

    private static int medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int low = 0;
        int high = n1;
        int left = (n1+n2+1)/2;
        int n = n1+n2;
        if(n1>n2) {
            return medianOfTwoSortedArrays(arr2, arr1);
        }
        while(low<=high) {
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            if(mid1<n1) {
                r1 = arr1[mid1];
            }
            if(mid2<n2) {
                r2=arr2[mid2];
            }
            if(mid1-1>=0) {
                l1 = arr1[mid1-1];
            }
            if(mid2-1>=0) {
                l2 = arr2[mid2-1];
            }
            if(l1<=r2 && l2<=r1) {
                if(n%2!=0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2;
                }
            } else if(l1>r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }
        return 0;
    }
}