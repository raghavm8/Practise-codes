package Arrays.PrefixSum;

public class EvenNumbersInRange {
    public static void main(String[] args) {

    }

    public int[] solve(int[] a, int[][] b) {
        int n = a.length;
        int rows = b.length;
        int[] ans = new int[rows];
        int[] prefixedArray = new int[n];

        prefixedArray[0] = isEven(a[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (isEven(a[i])) {
                prefixedArray[i] = ++prefixedArray[i - 1];
            } else {
                prefixedArray[i] = prefixedArray[i - 1];
            }
        }

        for (int i = 0; i < rows; i++) {
            int left = b[i][0];
            int right = b[i][1];

            if (left == 0)
                ans[i] = prefixedArray[right];
            else
                ans[i] = prefixedArray[right] - prefixedArray[left - 1];
        }

        return ans;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
