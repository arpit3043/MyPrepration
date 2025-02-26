package BitManipulation;
public class BItwiseANDinRange {
    public static void main(String[] args) {
        int left=4;
        int right=8;
        System.out.println(rangeBitwiseAnd(left, right));
    }
    private static int rangeBitwiseAnd(int left, int right) {
        int ans=0;
        while(left!=right) {
            left>>=1;
            right>>=1;
            ans++;
        }
        return (left<<ans);
    }
}
