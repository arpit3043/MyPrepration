package Graph;
public class TownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {
                {1,3},
                {2,3}
        };
        System.out.println(findJudgeInTown(n, trust));
    }

    private static int findJudgeInTown(int n, int[][] trust) {
        int[] result = new int[n+1];
        for (int[] ints : trust) {
            result[ints[0]] = result[ints[0]] - 1;
            result[ints[1]] = result[ints[1]] + 1;
        }
        for(int index = 1; index<=n; index++) {
            int temp = result[index];
            if(temp == n-1) {
                return index;
            }
        }
        return -1;
    }
}