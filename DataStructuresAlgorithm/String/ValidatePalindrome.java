package String;

public class ValidatePalindrome {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        //your code goes here
        String newString = reverseString(s);
        return newString.equals(s);
    }

    private static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
        return new String(chars);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


