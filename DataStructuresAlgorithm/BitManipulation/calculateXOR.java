package BitManipulation;
public class calculateXOR {
    public static void main(String[] args) {
        int n=7;
        System.out.println(calculateXOR(n));
    }
    private static int calculateXOR(int n) {
        int ans = 0;
        if(n%4==0) {
            ans=n;
        } else if(n%4==3) {
            ans=0;
        } else if(n%4==1) {
            ans=1;
        } else if(n%4==2) {
            ans = n+1;
        }
        return ans;
    }
}