package AdvancedDSA.DynamicProgramming;

import java.util.Arrays;

public class CuttingRod {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, 1, 6, 2 };
        int ans = new CuttingRod().solve(arr);
        System.out.println(ans);
    }

    public int solve(int[] A) {
        int n = A.length;
        int[] ans = new int[n + 1];

        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = A[i - 1];
            for (int j = 0; j <= i; j++) {
                ans[i] = Math.max(ans[j] + ans[i - j], ans[i]);
            }
        }
        return ans[n];
    }
}
