package Arrays.Matrices;

public class AntiDiagonals {
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int diagonals = (2 * n) - 1;
        int[][] ans = new int[diagonals][n];
        int r = 0, c = 0;

        for (int i = 0; i < diagonals; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 0;
            }
        }

        for (int col = 0; col < n; col++) {
            int i = 0, j = col;
            while (i < n && j >= 0) {
                ans[r][c] = A[i][j];
                i++;
                j--;
                c++;
            }
            c = 0;
            r++;
        }

        for (int row = 1; row < n; row++) {
            int i = row, j = n - 1;
            while (i < n && j >= 0) {
                ans[r][c] = A[i][j];
                i++;
                j--;
                c++;
            }
            c = 0;
            r++;
        }

        return ans;
    }
}
