package BitManipulation;
public class smallestXOR {
    public static void main(String[] args) {
        int A = 3;
        int B = 3;
        System.out.println(smallestXORNumber(A, B));
    }
    private static int smallestXORNumber(int A, int B) {
        int Ans = 0;
        for(int i=31; i>=0; --i) {
            if(checkSetBit(A, i) && B>0){
                Ans = Ans | (1<<i) ;
                B--;
            }
        }
        if(B>0) {
            for(int i=0; i<32; ++i) {
                if(!checkSetBit(A, i) && B>0) {
                    Ans = Ans | (1<<i);
                    B--;
                }
            }
        }
        return Ans;
    }

    private static boolean checkSetBit(int A, int i) {
        if(((A>>i) & 1)==1) {
            return true;
        }
        return false;
    }
}