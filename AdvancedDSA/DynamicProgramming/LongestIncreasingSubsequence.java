package AdvancedDSA.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public int lis(final int[] A) {
        int ans = 0;
        int n = A.length;
        int[] length = new int[n];
        int[] previous = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            previous[i] = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && length[i] <= length[j]) {
                    length[i] = length[j] + 1;
                    previous[i] = j;
                }
            }
        }

        ans = length[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, length[i]);
        }
        return ans;
    }
}
