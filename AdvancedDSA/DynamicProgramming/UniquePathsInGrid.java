package AdvancedDSA.DynamicProgramming;

public class UniquePathsInGrid {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] ways = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    ways[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    ways[i][j] = 1;
                } else if (i == 0) {
                    ways[i][j] = ways[i][j - 1];
                } else if (j == 0) {
                    ways[i][j] = ways[i - 1][j];
                } else {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }
        return ways[n - 1][m - 1];
    }

    public int uniquePathsWithObstacles_SC(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] previous = new int[m];
        int[] current = new int[m];

        for (int i = 0; i < n; i++) {
            int[] temp = previous;
            previous = current;
            current = temp;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    current[j] = 0;
                } else if (i == 0 && j == 0) {
                    current[j] = 1;
                } else if (i == 0) {
                    current[j] = current[j - 1];
                } else if (j == 0) {
                    current[j] = previous[j];
                } else {
                    current[j] = previous[j] + current[j - 1];
                }
            }
        }
        return current[m - 1];
    }
}
