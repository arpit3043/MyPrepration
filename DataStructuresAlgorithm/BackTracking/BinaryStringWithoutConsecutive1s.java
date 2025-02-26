package BackTracking;
import java.util.ArrayList;
import java.util.List;
public class BinaryStringWithoutConsecutive1s {
    public static void main(String[] args) throws Exception {
        int N=4;
        System.out.println(generateString(N));
    }
    public static List<String> generateString(int N) {
        List<String> res = new ArrayList<>();
        Boolean flag = false;
        generateStringHelper(new StringBuilder(), flag, 0, res, N);
        return res;
    }

    private static void generateStringHelper(StringBuilder sb,boolean flag,int idx,List<String> res,int n){
        if(idx==n) {
            if(sb.length()==n){
                res.add(sb.toString());
            }
            return;
        }
        sb.append("0");
        generateStringHelper(sb, false, idx+1, res, n);
        sb.deleteCharAt(sb.length()-1);
        if(!flag) {
            sb.append("1");
            generateStringHelper(sb, true, idx+1, res, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}