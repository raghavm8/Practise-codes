package Arrays.PrefixSum;

public class RangeSumQuery {
    public static void main(String[] args) {

    }

    public long[] rangeSum(int[] a, int[][] b) {
        int n = a.length;
        int rows = b.length;
        long[] ans = new long[rows];
        long[] prefixArray = new long[n];

        prefixArray[0] = a[0];
        for (int i = 1; i < n; i++)
            prefixArray[i] = prefixArray[i - 1] + a[i];

        for (int i = 0; i < rows; i++) {
            int left = b[i][0];
            int right = b[i][1];

            if (left == 0)
                ans[i] = prefixArray[right];
            else
                ans[i] = prefixArray[right] - prefixArray[left - 1];
        }

        return ans;
    }
}

// [1, 2, 3, 4, 5]
// [1, 3, 6, 10, 15]