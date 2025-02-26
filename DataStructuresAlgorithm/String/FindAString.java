package String;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;
public class FindAString {
    public static void main(String[] args) {
        int n=3;
        int m=3;
        int q=2;
        String[] websites = {"abc", "aac", "aba"};
        String[] queries = {"ab?", "?a?"};
        System.out.println(browserQuery(n,m,q,websites,queries));
    }
    private static ArrayList<Integer> browserQuery(int n, int m, int q, String[] websites, String[] queries) {
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String current = websites[i];
            for (int j = 0; j < (1 << m); j++){
                String modified = current;
                for (int k = 0; k < m; k++){
                    if ((j & (1 << k)) > 0){
                        modified = modified.substring(0, k) + '?' + modified.substring(k + 1);
                    }
                }
                if (hash.containsKey(modified)) {
                    hash.put(modified, hash.get(modified) + 1);
                } else {
                    hash.put(modified, 1);
                }
            }
        }
        for (int i = 0; i < q; i++){
            if (hash.containsKey(queries[i])){
                answer.add(hash.get(queries[i]));
            } else {
                answer.add(0);
            }
        }
        return new ArrayList<Integer>(answer);
    }
}