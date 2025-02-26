package String;
public class currencyConverter {
    public static void main(String[] args) {
        System.out.println(convertCurrency("$4"));
        System.out.println(convertCurrency("$0"));
        System.out.println(convertCurrency("$1"));
        System.out.println(convertCurrency("$12.01"));
        System.out.println(convertCurrency("$90.00"));
        System.out.println(convertCurrency("$100"));
        System.out.println(convertCurrency("$701.82"));
    }
    private static final String[] units = {
            "zero", "one", "two", "three",
            "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty",
            "thirty", "forty",
            "fifty", "sixty",
            "seventy", "eighty",
            "ninety"
    };
    private static final String HUNDRED = "hundred";
    private static final String DOLLARS = "dollar";
    private static final String CENTS = "cents";
    private static final String AND = "and";

    private static String convertCurrency(String numStr) {
        int dollarAmount = parseDollars(numStr);
        int centsAmount = parseCents(numStr);
        String dollarString = convertNumberToWords(dollarAmount, true);
        String centsString = convertNumberToWords(centsAmount, false);
        StringBuilder resultBuilder = new StringBuilder(dollarString);
        if (!dollarString.isEmpty() && !centsString.isEmpty()) {
            resultBuilder.append(" ").append(AND).append(" ");
        }
        if (!centsString.isEmpty()) {
            resultBuilder.append(centsString);
        }
        return resultBuilder.toString().trim();
    }

    private static int parseDollars(String numStr) {
        int indexOfDecimal = numStr.indexOf('.');
        if (indexOfDecimal == -1) {
            return Integer.parseInt(numStr.substring(1).trim());
        } else {
            return Integer.parseInt(numStr.substring(1, indexOfDecimal).trim());
        }
    }

    private static int parseCents(String numStr) {
        int indexOfDecimal = numStr.indexOf('.');
        if (indexOfDecimal == -1) {
            return 0;
        } else {
            return Integer.parseInt(numStr.substring(indexOfDecimal + 1).trim());
        }
    }

    private static String convertNumberToWords(int number, boolean isDollars) {
        if (number == 0) {
            return isDollars ? units[0] + " " + DOLLARS : "";
        }
        if (number < 20) {
            return units[number] + (isDollars ? " " + DOLLARS : " " + CENTS);
        }
        if (number < 100) {
            return tens[number / 10] + (number % 10 > 0 ? " " + units[number % 10] : "") + (isDollars ? " " + DOLLARS : " " + CENTS);
        }
        return units[number / 100] + " " + HUNDRED + (number % 100 > 0 ? " " + convertNumberToWords(number % 100, true) : "") + (isDollars ? " " + DOLLARS : " " + CENTS);
    }
}