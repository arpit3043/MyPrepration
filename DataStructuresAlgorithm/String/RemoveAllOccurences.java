package String;
public class RemoveAllOccurences {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        removeAllOccurencesOfChar(str, 'g');
    }
    private static void removeAllOccurencesOfChar(String s, char c) {
        int j, count = 0;
        int n = s.length();
        char []t = s.toCharArray();
        for (int i = j = 0; i < n; i++) {
            if (t[i] != c) {
                t[j] = t[i];
                j++;
            }
            else {
                count++;
            }
        }
        while(count > 0) {
            t[j] = '\0';
            j++;
            count--;
        }
        System.out.println(t);
    }
}