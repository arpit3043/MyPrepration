package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
class IntersectionOfTwoArrays {
    // Main method to demonstrate the intersectionOfArrays function.
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        // Print the intersection of nums1 and nums2.
        System.out.println(Arrays.toString(intersectionOfArrays(nums1, nums2)));
    }
    
    // Optimized Function to find intersection of two arrays.
    private static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        // Initialize variables for lengths of nums1 and nums2.
        int n = nums1.length;
        int m = nums2.length;
        List<Integer>list = new ArrayList<>();
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        for(int i=0; i<n; i++) {
            set1.add(nums1[i]);
        }
        for (int j=0; j<m; j++) {
            set2.add(nums2[j]);
        }
        for(Integer num1: set1) {
            for(Integer num2 : set2) {
                if(num1 == num2) {
                    list.add(num1);
                    break;
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    // Function to find intersection of two arrays.
    /*
    private static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        // Initialize variables for lengths of nums1 and nums2.
        int n = nums1.length;
        int m = nums2.length;
        // Initialize a temporary array of size 1001 (assuming the max value of elements in nums1 and nums2 is 1000).
        int[] temp = new int[1001];
        // Iterate through nums1 and mark the presence of each element in temp array with 1.
        for(int i = 0; i < n; i++){
            temp[nums1[i]] = 1;
        }
        // Iterate through nums2 and check if an element exists in temp array with value 1.
        // If yes, update its value to 2, increment the count of common elements.
        int count = 0;
        for(int i = 0; i < m; i++){
            if(temp[nums2[i]] == 1) {
                temp[nums2[i]] = 2;
                count++;
            }
        }
        // Initialize an integer array 'ans' of size equal to the count of common elements.
        int[] ans = new int[count];
        // Iterate through temp array and copy the elements with value 2 into the ans array.
        for(int i = 0, j = 0; i < temp.length && j < count; i++){
            if(temp[i] == 2) {
                ans[j] = i;
                j++;
            }
        }
        // Return the intersection array 'ans' containing common elements from nums1 and nums2.
        return ans;
    }
    */
}