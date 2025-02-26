
public class FirstRepeatingCharacter {
    public static void main(String[] args) {
        String str = "212345";
        System.out.println(findFirstRepeatingDigit(str));
    }
    private static int findFirstRepeatingDigit(String digitpattern) {
        int n = digitpattern.length();
        int bitmask = 0;
        for(int i=0; i<n; i++) {
            int digit = digitpattern.charAt(i) - '0';
            if((bitmask & (1<<digit))>0) {
                return digit;
            }
            bitmask = bitmask + (1 << digit);
        }
        return -1;
    }
}