package String;
public class StringToWords {
    public static void main(String[] args) {
        long n1 = 123456789;
        long n2 = 10101010110001L;
        long n3 = 999999999;
        long n4 = 36L;
        System.out.println(numberToWords(n1));
        System.out.println(numberToWords(n2));
        System.out.println(numberToWords(n3));
        System.out.println(numberToWords(n4));
    }
    private static String numberToWords(long n) {
        long limit = 1000000000000L;
        long currHund;
        long t = 0;
        if (n == 0) {
            return ("Zero");
        }
        String[] multiplier = {
                "", "Ten Crore", "Crore", "Lakh", "Thousand"
        };
        String[] firstTwenty = {
                "",	 "One",	 "Two",	 "Three",
                "Four", "Five",	 "Six",	 "Seven",
                "Eight", "Nine",	 "Ten",	 "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {
                "",	 "Twenty", "Thirty",
                "Forty", "Fifty", "Sixty",
                "Seventy", "Eighty", "Ninety"
        };
        if (n < 20L) {
            return (firstTwenty[(int)n]);
        }
        String answer = "";
        for (long i = n; i > 0; i %= limit, limit /= 1000) {
            currHund = i / limit;
            while (currHund == 0) {
                i = i%limit;
                limit = limit/1000;
                currHund = i / limit;
                ++t;
            }
            if (currHund > 99) {
                answer = answer + (firstTwenty[(int) currHund / 100] + " Hundred ");
            }
            currHund = currHund % 100;
            if (currHund > 0 && currHund < 20) {
                answer = answer + (firstTwenty[(int)currHund] + " ");
            } else if (currHund % 10 == 0 && currHund != 0) {
                answer += (tens[(int)currHund / 10 - 1] + " ");
            } else if (currHund > 20 && currHund < 100)
                answer += (tens[(int)currHund / 10 - 1] + " "
                        + firstTwenty[(int)currHund % 10]
                        + " ");
            if (t < 4) {
                answer += (multiplier[(int)++t] + " ");
            }
        }
        return (answer);
    }
}