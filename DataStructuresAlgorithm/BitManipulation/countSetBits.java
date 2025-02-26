package BitManipulation;

public class countSetBits {
    public static void main(String[] args) throws Exception {
        int N=8;
        System.out.println(setBits(N));
    }
    private static int setBits(int N) {
        int count = 0;
        while(N>0) {
            if((N&1)>0) {
                count++;
            }
            N=N>>1;
        }
        return count;
    }
}