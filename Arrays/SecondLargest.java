package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] dummyArray = { 23, 56, 11, 89, 45, 78, 34, 67, 90, 12 };
        System.out.println(solve(dummyArray));
    }

    public static int solve(int[] a) {
        int first = Integer.MIN_VALUE;
        int second = first;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            } else if (a[i] < first && a[i] > second) {
                second = a[i];
            }
        }
        return second > Integer.MIN_VALUE ? second : -1;
    }
}
