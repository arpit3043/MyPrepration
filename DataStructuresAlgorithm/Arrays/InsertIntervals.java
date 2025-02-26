package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        System.out.println(Arrays.deepToString(insertIntervals(intervals, newInterval)));
    }

    private static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                mergedIntervals.add(interval);
            } else if (interval[0] > newInterval[1]) {
                mergedIntervals.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        mergedIntervals.add(newInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}