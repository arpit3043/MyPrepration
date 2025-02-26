package BitManipulation;
public class setAllBitsInRange {
    public static void main(String[] args) {
        int num=37;
        int k=4;
        System.out.println(SetAllBitsInRange(num, k));
    }
    private static int SetAllBitsInRange(int num, int k){
        return num|((1<<k)-1);
    }
}