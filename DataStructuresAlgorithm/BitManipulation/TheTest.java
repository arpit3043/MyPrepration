package BitManipulation;
public class TheTest {
    public static void main(String[] args) throws Exception {
        String s="100";
        System.out.println(testToFindMinimumTotalSum(s));
    }
    private static long testToFindMinimumTotalSum(String s) {
        int n=s.length();
        long ans=0;
        int[] arr1=new int[n+1];
        int[] arr2=new int[n+1];
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='1') {
                arr1[i+1]=arr1[i]+1;
            }
        }
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i)=='0') {
                arr2[i]=arr2[i+1]+1;
            }
        }
        for(int i=0; i<n+1; i++) {
            ans=ans+Math.max(arr1[i], arr2[i]);
        }
        return ans;
    }
}