package Hashing.HashMap;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccuringElement {
    public static void main(String[] args) {
        int[] arr = {4, 4, 5, 5, 6, 7};
        System.out.println(secondMostFrequentElement(arr));
    }

    private static int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() == getSecondMaxValue(map)) {
                return entrySet.getKey();
            }
        }
        return -1;
    }

    private static int getSecondMaxValue(Map<Integer, Integer> map) {
        int firstMaxVal = getFirstMaxValue(map);
        int secondMaxValue = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > secondMaxValue && value != firstMaxVal) {
                secondMaxValue = value;
            }
        }
        return secondMaxValue;
    }

    private static int getFirstMaxValue(Map<Integer, Integer> map) {
        int firstMaxVal = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > firstMaxVal) {
                firstMaxVal = value;
            }
        }
        return firstMaxVal;
    }
}
