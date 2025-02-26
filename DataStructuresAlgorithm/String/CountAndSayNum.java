package String;
public class CountAndSayNum {
    public static void main(String[] args) throws Exception {
        int n=4;
        System.out.println(countAndSay(n));
    }
    private static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            ans = countAndSayHelper(ans);
        }
        return ans.toString();
    }

    private static StringBuilder countAndSayHelper(StringBuilder prev) {
        StringBuilder ans = new StringBuilder();
        int freq = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                ans.append(freq);
                ans.append(prev.charAt(i));
                freq = 1;
            } else {
                freq++;
            }
        }
        return ans;
    }
}