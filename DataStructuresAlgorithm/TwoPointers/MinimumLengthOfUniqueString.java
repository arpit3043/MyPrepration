package TwoPointers;

public class MinimumLengthOfUniqueString {
    public static void main(String[] args) {
        String s = "aabccabba";
        System.out.println(minimumLengthOfUniqueStringWithoutSimilarEnds(s));
    }
    private static int minimumLengthOfUniqueStringWithoutSimilarEnds(String s) {
        int n=s.length();
        int start=0;
        int end=n-1;
        int maxLength = Integer.MIN_VALUE;
        while(start<end && s.charAt(start)==s.charAt(end)) {
            char current = s.charAt(start);
            while(start<=end && s.charAt(start)==current) {
                start++;
            }
            while(start<=end && s.charAt(end)==current) {
                end--;
            }
        }
        return Math.max(maxLength, end-start+1);
    }
}
