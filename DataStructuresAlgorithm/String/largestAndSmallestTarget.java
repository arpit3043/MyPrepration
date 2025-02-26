package String;
public class largestAndSmallestTarget {
    public static void main(String[] args) throws Exception {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int start=0;
        int end=N-1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(letters[mid]<=target) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return letters[(end+1)%N];
    }
}