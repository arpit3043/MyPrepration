package String;
public class FamilyStructure {
    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        System.out.println(kthChildNthGeneration(n, k));
    }
    private static String kthChildNthGeneration(int n, long k) {
        if(n == 1 || k == 1) {
            return "Male";
        }
        long ParentK = (k+1)/2;
        String parent = kthChildNthGeneration(n-1, ParentK);
        if(k%2==1){
            return parent;
        } else {
            if(parent=="Male") {
                return "Female";
            }
            return "Male";
        }
    }
}
