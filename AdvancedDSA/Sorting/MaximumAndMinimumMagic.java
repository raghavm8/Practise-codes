package AdvancedDSA.Sorting;

import java.util.Arrays;

public class MaximumAndMinimumMagic {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int[] ans = new int[2];
        int n = A.length;
        long max = 0;
        long min = 0;
        int mod = 1000000007;

        Arrays.sort(A);

        for (int i = 0; i < n / 2; i++) {
            max = (max + (long) Math.abs(A[i] - A[n - i - 1]) % mod) % mod;
        }

        for (int i = 0; i < n; i += 2) {
            min = (min + (long) Math.abs(A[i] - A[i + 1]) % mod) % mod;
        }

        ans[0] = (int) max;
        ans[1] = (int) min;

        return ans;
    }
}