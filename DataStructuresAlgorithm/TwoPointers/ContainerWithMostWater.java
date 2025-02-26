package TwoPointers;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaInsideContainer(arr));
    }
    private static int maxAreaInsideContainer(int[] height) {
        int N = height.length;
        int area = 0;
        int maxArea = Integer.MIN_VALUE;
        int i=0;
        int j=N-1;
        int[] prefixMax = generatePrefixMax(height);
        int[] suffixMax = generateSuffixMax(height);
        while(i<j) {
            area = minima(prefixMax[i], suffixMax[j])*(j-i);
            maxArea = maxima(area, maxArea);
            if(height[i]<height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    private static int[] generateSuffixMax(int[] height) {
        int N = height.length;
        int[] suffixMax = new int[N];
        suffixMax[N-1] = height[N-1];
        for(int i=N-2; i>=0; i--) {
            suffixMax[i] = maxima(height[i], suffixMax[i+1]);
        }
        return suffixMax;
    }

    private static int[] generatePrefixMax(int[] height) {
        int N = height.length;
        int[] prefixMax = new int[N];
        prefixMax[0] = height[0];
        for(int i=1; i<N; i++) {
            prefixMax[i] = maxima(height[i], prefixMax[i-1]);
        }
        return prefixMax;
    }

    private static int maxima(int a, int b) {
        if(a>b) {
            return a;
        } else {
            return b;
        }
    }

    private static int minima (int a, int b) {
        if(a>b) {
            return b;
        } else {
            return a;
        }
    }
}