package Arrays;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;
import java.util.Arrays;
public class missingAndRepeatingNumber {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(6,4,3,5,5,1));
        int N = arr.size();
        int[] ans = missingAndRepeating(arr, N);
        printArray(ans);
    }

    private static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xor=0;
        int totalXor=0;
        for(int i=0; i<n; i++) {
            xor = xor^arr.get(i);
            totalXor = totalXor^(i+1);
        }
        int mix = xor^totalXor;
        int temp = mix;
        int bit = 1;
        while(temp!=0) {
            if((temp&1)==1) {
                break;
            }
            bit++;
            temp=temp>>1;
        }
        int t=1<<(bit-1);
        int c1=0;
        int c2=0;
        for(int i=0; i<n; i++) {
            if((arr.get(i)&t)==0) {
                c1=c1^arr.get(i);
            } else {
                c2=c2^arr.get(i);
            }
            if(((i+1)&t)==0) {
                c1 = c1^(i+1);
            } else {
                c2 = c2^(i+1);
            }
        }
        int res[]=new int[2];
        for(int i=0; i<n; i++) {
            if(c1==arr.get(i)) {
                res[1]=c1;
                res[0]=c2;
            } else if(c2==arr.get(i)) {
                res[1]=c2;
                res[0]=c1;
            }
        }
        return res;
    }

    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}