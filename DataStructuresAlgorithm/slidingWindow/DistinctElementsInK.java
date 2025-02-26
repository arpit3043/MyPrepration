package slidingWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class DistinctElementsInK {
    public static void main(String[] arg) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 2, 3));
        int K = 4;
        System.out.println(countDistinctElements(arr, K));
    }
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.size()){
            int window = j-i+1;
            int elemAtJ = arr.get(j);
            map.put(elemAtJ,map.getOrDefault(elemAtJ, 0) + 1);
            if(window == k){
                result.add(map.size());
                int elemAtI = arr.get(i);
                map.put(elemAtI, map.get(elemAtI) - 1);
                if(map.get(elemAtI) == 0){
                    map.remove(elemAtI);
                }
                i++;
            }
            j++;
        }
        return result;
    }
}