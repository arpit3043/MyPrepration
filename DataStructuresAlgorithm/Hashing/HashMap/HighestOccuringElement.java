package Hashing.HashMap;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

public class HighestOccuringElement {
    public static void main(String[] args) {
        int[] arr = {4, 4, 5, 5, 6};
        System.out.println(mostFrequentElement(arr));
    }

    private static int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() == getMaxValue(map)) {
                return entrySet.getKey();
            }
        }
        return -1;
    }

    private static int getMaxValue(Map<Integer, Integer> map) {
        int maxVal = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > maxVal) {
                maxVal = value;
            }
        }
        return maxVal;
    }
}
