package AdvancedDSA.DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapSack {
    public int solve(int[] values, int[] weights, int c) {
        int n = values.length;
        int[][] happiness = new int[n + 1][c + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < c + 1; j++) {
                happiness[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                happiness[i][j] = happiness[i - 1][j];
                if (weights[i - 1] > j) {
                    happiness[i][j] = happiness[i - 1][j];
                } else {
                    happiness[i][j] = Math.max(happiness[i - 1][j],
                            values[i - 1] + happiness[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return happiness[n][c];
    }

    // static int maxn = 1009;
    // static int[][] dp = new int[maxn][maxn];

    public static int knapsack(int[] A, int[] B, int C) {
        int[][] dp = new int[A.length][C + 1];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        int n = A.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (B[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i][j], A[i - 1] + dp[i - 1][j - B[i - 1]]);
            }
        }
        return dp[n][C];
    }
}

// int pick = 0;
// int notpick = happiness[i - 1][j];
// if (weights[i] <= j) {
// pick = values[i] + happiness[i - 1][j - weights[i]];
// }

// happiness[i][j] = Math.max(pick, notpick);