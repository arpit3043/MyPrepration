package String;
public class BullCow {
    public static void main(String[] args) throws Exception {
        String secret = "1807";
        String guess = "7810";
        System.out.println(getHint(secret, guess));
    }
    private static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (numbers[secret.charAt(i)-'0']++ < 0) {
                    cows++;
                }
                if (numbers[guess.charAt(i)-'0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}