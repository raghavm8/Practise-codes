package Arrays.Matrices;

public class RowColumnZero {
    public int[][] solve(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        boolean[] r = new boolean[rows];
        boolean[] c = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (r[i] || c[j]) {
                    a[i][j] = 0;
                }
            }
        }

        return a;
    }
}
