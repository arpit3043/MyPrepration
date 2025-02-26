package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Integer;
import java.lang.String;
public class TrianglePerimeter {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(3,7,1,5));
        int n=arr.size();
        System.out.println(maxPerimeterTriangle(arr, n));
    }
    private static int maxPerimeterTriangle(ArrayList<Integer> arr, int n) {
        int count = 0;
        Collections.sort(arr);
        int i = n-1;
        int j = i-1;
        while (j > 0 && i >= 2){
            if (arr.get(j)+arr.get(j-1)>arr.get(i)){
                count = Math.max(count,(arr.get(i)+arr.get(j)+arr.get(j-1)));
                --i;
                j=i-1;
            } else {
                --j;
            }
            if (j == 0){
                --i;
                j = i-1;
            }
        }
        return count;
    }
}