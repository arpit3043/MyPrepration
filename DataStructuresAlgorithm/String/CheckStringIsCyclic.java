package String;
public class CheckStringIsCyclic {
    public static void main(String[] args) {
        String p="abac";
        String q="baca";
        System.out.println(isCyclicRotation(p, q));
    }
    private static int isCyclicRotation(String p, String q)  {
        int n=p.length();
        int start=0;
        for(int i=0; i<n; i++) {
            if(p.charAt(i)==q.charAt(0)) {
                start=i;
                String res=(p.substring(start) +p.substring(0,start));
                if(res.equals(q)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}