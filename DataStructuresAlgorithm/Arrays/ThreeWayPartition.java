package Arrays;
import java.util.Arrays;
public class ThreeWayPartition {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 4};
        int a=1;
        int b=2;
        threeWayPartition(A, a, b);
        System.out.println(Arrays.toString(A));
    }
    private static void threeWayPartition(int[] array, int a, int b) {
        int smaller=0;
        int between=0;
        int larger=array.length-1;
        while(between<=larger){
            if(array[between]<a){
                swap(array,smaller,between);
                smaller++;
                between++;
            } else if(array[between]>=a && array[between]<=b) {
                between++;
            } else {
                swap(array,larger,between);
                larger--;
            }
        }
    }

    private static void swap(int[] array, int a, int b){
        int temp=array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}