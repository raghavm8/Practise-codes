package Arrays.Matrices;

public class MinorDiagonal {
    public int solve(final int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][A.length - i - 1];
        }
        return sum;
    }
}
