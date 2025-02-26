package TortoiseHeir;
public class HappyNumber {
    public static void main(String[] args) throws Exception {
        int n = 12;
        System.out.println(isHappyNumber(n));
    }
    private static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while(slow!=fast);
        return slow == 1;
    }
    private static int square(int num) {
        int ans = 0;
        while(num > 0) {
            int remainder = num % 10;
            ans = ans + remainder * remainder;
            num = num/10;
        }
        return ans;
    }
}