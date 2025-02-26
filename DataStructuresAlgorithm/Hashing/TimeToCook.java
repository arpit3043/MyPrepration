package Hashing;
public class TimeToCook {
    public static void main(String[] args) {
        int[] time = {3, 2, 1};
        int[][] order = {
                { 1, 2 },
                { 3, 1 },
                { 2, 3 },
                { 1, 1 }
        };
        System.out.println(timeToCook(time, order));
    }
    private static int timeToCook(int[] time, int[][] order) {
        int N=time.length;
        int M=order.length;
        int maxTime = Integer.MIN_VALUE;
        int mostCookedFoodID = 0;
        int[] cookingTimes = new int[N];
        for (int i = 0; i <M; i++) {
            int foodID = order[i][0];
            int amount = order[i][1];
            cookingTimes[foodID - 1] += amount * time[foodID - 1];
        }
        for (int i = 0; i < N; i++) {
            if (cookingTimes[i] > maxTime) {
                maxTime = cookingTimes[i];
                mostCookedFoodID = i + 1;
            } else if (cookingTimes[i] == maxTime) {
                mostCookedFoodID = Math.min(mostCookedFoodID, i + 1);
            }
        }
        return mostCookedFoodID;
    }
}