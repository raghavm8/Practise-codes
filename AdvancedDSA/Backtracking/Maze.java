package AdvancedDSA.Backtracking;

public class Maze {
    public static void main(String[] args) {
        int[][] a = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        Maze m = new Maze();
        System.out.println(m.solve(a));
    }

    public int ans = 0;

    public int solve(int[][] A) {
        // int ans = 0;
        int rows = A.length;
        int cols = A[0].length;

        PairRowCol start = new PairRowCol();
        PairRowCol end = new PairRowCol();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 2) {
                    end = new PairRowCol(i, j);
                } else if (A[i][j] == 1) {
                    start = new PairRowCol(i, j);
                }
            }
        }

        getPaths(A, start, end, rows, cols);
        return ans;
    }

    private void getPaths(int[][] a, PairRowCol start, PairRowCol end, int rows, int cols) {
        int currentRow = start.row;
        int currentCol = start.col;

        if (currentRow == end.row && currentCol == end.col && check(a) == true) {
            ans += 1;
            return;
        }
        
        if (currentRow < 0 || currentRow >= rows || currentCol < 0 || currentCol >= cols)
            return;

        if (a[currentRow][currentCol] == -1 || a[currentRow][currentCol] == 3 ||
                a[currentRow][currentCol] == 2)
            return;

        a[currentRow][currentCol] = 3;

        getPaths(a, new PairRowCol(currentRow + 1, currentCol), end, rows, cols);
        getPaths(a, new PairRowCol(currentRow - 1, currentCol), end, rows, cols);
        getPaths(a, new PairRowCol(currentRow, currentCol + 1), end, rows, cols);
        getPaths(a, new PairRowCol(currentRow, currentCol - 1), end, rows, cols);

        a[currentRow][currentCol] = 0;
    }

    private boolean check(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

class PairRowCol {
    public int row;
    public int col;

    PairRowCol(int r, int c) {
        row = r;
        col = c;
    }

    PairRowCol() {
    }
}
