package Arrays.Matrices;

public class MatrixTranspose {
    public int[][] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] ans = new int[cols][rows];
        int r = 0, c = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[r][c] = A[i][j];
                r++;
            }
            c++;
            r = 0;
        }
        return ans;
    }
}
