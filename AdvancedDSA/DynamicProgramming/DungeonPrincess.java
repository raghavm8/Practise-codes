package AdvancedDSA.DynamicProgramming;

public class DungeonPrincess {
    public static void main(String[] args) {

    }

    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] ans = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    ans[i][j] = Math.max(1 - A[i][j], 1);
                } else if (i == n - 1) {
                    int x = ans[i][j + 1];
                    ans[i][j] = Math.max(x - A[i][j], 1);
                } else if (j == m - 1) {
                    int x = ans[i + 1][j];
                    ans[i][j] = Math.max(x - A[i][j], 1);
                } else {
                    int x = Math.min(ans[i][j + 1], ans[i + 1][j]);
                    ans[i][j] = Math.max(x - A[i][j], 1);
                }
            }
        }
        return ans[0][0];
    }
}
