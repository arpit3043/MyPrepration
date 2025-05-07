package Tree;
/*
 * Segment Tree is a data structures that allows efficient querying and updating of intervals or segments of an array.
 * It is particularly useful for problems involving range queries, such as finding 
 * the sum, minimum, maximum, or any other operation over a specific range of elements in an array.
 * The tree is built recursively by dividing the array into segments until each segment represents a single element.
 * This structure enables fast query and update operations with a time complexity of O(log n), making it a powerful tool in algorithm design and optimization
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    static class Pair {
        int first;
        int second;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of the LIS: " + findLIS(arr, n));
    }

    private static void buildTree(int[] tree, int pos, int low, int high, int index, int value) {
        // Index is the original index of current element
        // If the index is not present in the given range,
        // then simply return
        if (index < low || index > high) {
            return;
        }

        // If low == high then the current position
        // should be updated to the value
        if (low == high) {
            tree[pos] = value;
            return;
        }
 
        int mid = (high + low) / 2;
 
        // Recursively call the function on the
        // child nodes
        buildTree(tree, 2 * pos + 1, low, mid, index, value);
        buildTree(tree, 2 * pos + 2, mid + 1, high, index, value);
 
        // Assign the current position the max of
        // the 2 child nodes
        tree[pos] = Math.max(tree[2 * pos + 1], tree[2 * pos + 2]);
    }
 
    // Function to query the Segment tree and
    // return the value for a given range
    private static int findMax(int[] tree, int pos, int low, int high, int start, int end) {
        // Query: Same as the query function of Segment
        // tree. If the current range is totally inside
        // the query range, return the value of current
        // position
        if (low >= start && high <= end) {
            return tree[pos];
        }

        // If it is out of bound, return the minimum
        // which would be 0 in this case
        if (start > high || end < low) {
            return 0;
        }
 
        // Partial overlap
        int mid = (high + low) / 2;
 
        // Call findMax on child nodes recursively
        // and return the maximum of the two
        return Math.max(findMax(tree, 2 * pos + 1, low, mid, start, end),
        findMax(tree, 2 * pos + 2, mid + 1, high, start, end));
    }
 
    private static int findLIS(int arr[], int n) {
        // The array of pairs stores the integers
        // and indices in p[i]
        List<Pair> p = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            Pair p1 = new Pair();
            p1.first = arr[i];
            p1.second = i;
            p.add(p1);
        }
 
        // Sorting the array in increasing order
        // of the elements
        Collections.sort(p, (p1, p2) -> {
            /* For same values, element with the higher
               index appear earlier in the sorted array.
               This is for strictly increasing subsequence.
               For increasing subsequence, the lower index
                appears earlier in the sorted array. */
            if (p1.first == p2.first) {
                return p2.second - p1.second;
            }
            // Sorting the array according to their values.
            return p1.first - p2.first;
        });
 
        // Calculating the length of the segment-tree
        int len = (int)(Math.pow(
            2, (int)(Math.ceil(Math.sqrt(n))) + 1)) - 1;
        int[] tree = new int[len];

        // Building the segment-tree, the root node of
        // which contains the length of LIS for the n
        // elements
        for (int i = 0; i < n; i++) {
            buildTree(tree, 0, 0, n - 1, p.get(i).second,
            findMax(tree, 0, 0, n - 1, 0, p.get(i).second) + 1);
        }
        return tree[0];
    }
}
