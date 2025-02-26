package Stacks;
public class maximumCommonSum {
    public static void main(String[] args) {
        int[] stack1 = {3, 2, 1, 1, 1};
        int[] stack2 = {4, 3, 2};
        int[] stack3 = {1, 1, 4, 1};
        int maxCommonSum = maxStackSum(stack1, stack2, stack3);
        System.out.println("Max Common Sum: " + maxCommonSum);
    }
    public static int maxStackSum(int stack1[], int stack2[], int stack3[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (i = 0; i < stack1.length; i++) {
            sum1 += stack1[i];
        }
        for (j = 0; j < stack2.length; j++) {
            sum2 += stack2[j];
        }
        for (k = 0; k < stack3.length; k++) {
            sum3 += stack3[k];
        }
        while (i < stack1.length && j < stack2.length && k < stack3.length) {
            int maxSum = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 > maxSum) {
                sum1 -= stack1[i];
                i++;
            } else if (sum2 > maxSum) {
                sum2 -= stack2[j];
                j++;
            } else {
                sum3 -= stack3[k];
                k++;
            }
        }
        if (sum1 == sum2 && sum2 == sum3) {
            return sum1;
        }
        return 0;
    }
}