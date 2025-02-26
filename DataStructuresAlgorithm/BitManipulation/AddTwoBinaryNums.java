package BitManipulation;
public class AddTwoBinaryNums {
    public static void main(String[] args) {
        int x = 12731;
        int y = 38023;
        System.out.println("x (" + x + ") in binary is " + toBinaryString(x));
        System.out.println("y (" + y + ") in binary is " + toBinaryString(y));
        int[] arr = add(x, y);
        System.out.print("x + y is ");
        for (int i = 0; i < Integer.SIZE; i++) {
            System.out.printf("%d", arr[i]);
        }
    }
    private static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
                .replaceAll(" ", "0");
    }

    private static int[] add(int x, int y) {
        int carry = 0;
        int n = Integer.SIZE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if ((x & (1 << i)) != 0) {
                if ((y & (1 << i)) != 0) {
                    if (carry == 1) {
                        arr[n - i - 1] = 1;
                    } else {
                        arr[n - i - 1] = 0;
                        carry = 1;
                    }
                } else {
                    if (carry == 1) {
                        arr[n - i - 1] = 0;     // carry = 1
                    } else {
                        arr[n - i - 1] = 1;     // carry = 0
                    }
                }
            } else {
                if ((y & (1 << i)) != 0) {
                    if (carry == 1) {
                        arr[n - i - 1] = 0;     // carry = 1
                    } else {
                        arr[n - i - 1] = 1;     // carry = 0
                    }
                } else {
                    if (carry == 1) {
                        arr[n - i - 1] = 1;
                        carry = 0;
                    } else {
                        arr[n - i - 1] = 0;     // carry = 0
                    }
                }
            }
        }
        return arr;
    }
}