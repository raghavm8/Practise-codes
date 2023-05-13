import java.util.ArrayList;
import java.util.List;

public class DiagonalSum {
    public int solveMajorDiagonal(final List<ArrayList<Integer>> A) {
        int ans = 0;
        int index = 0;
        for (ArrayList<Integer> arrayList : A) {
            ans += arrayList.get(index++);
        }

        return ans;
    }

    public int solveMajorDiagonal(final int[][] A) {
        int ans = 0;
        int rows = A.length;
        for (int i = 0; i < rows; i++)
            ans += A[i][i];

        return ans;
    }

    public int solveMinorDiagonal(final int[][] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++)
            sum += A[i][n - i - 1];

        return sum;
    }
}