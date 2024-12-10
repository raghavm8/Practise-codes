package Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] dummyArray = { 23, 56, 11, 89, 45, 78, 34, 67, 90, 12 };
        solve(dummyArray, 3);
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;

        B %= B;
        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);
        return A;
    }

    public static void reverse(int[] a, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}