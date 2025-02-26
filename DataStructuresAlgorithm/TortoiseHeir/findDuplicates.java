package TortoiseHeir;
import java.util.ArrayList;
import java.util.Arrays;
public class findDuplicates {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 2, 1, 3, 1));
        System.out.println(findDuplicate(arr));
    }
    private static int findDuplicate(ArrayList<Integer> arr) {
        int N = arr.size();
        int slow = arr.get(0);
        int fast = arr.get(0);
        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while(slow!=fast);
        fast = arr.get(0);
        while(slow!=fast) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return slow;
    }
}