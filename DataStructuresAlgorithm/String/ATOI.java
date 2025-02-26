package String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ATOI {
    public static int createAtoi(String str) {
        String regex = "([+-]?)(\\d+)(.*)$";
        Pattern pattern = Pattern.compile(regex);
        str = str.trim();
        Matcher matcher = pattern.matcher(str);
        boolean match = matcher.matches();
        if (match) {
            String sign = matcher.group(1);
            String value = sign + matcher.group(2);
            boolean isNegative = false;
            if (str.startsWith("-")) {
                isNegative = true;
            }
            try {
                int intValue = Integer.parseInt(value);
                return intValue;
            } catch (NumberFormatException e) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            return 0;
        }
    }
}
