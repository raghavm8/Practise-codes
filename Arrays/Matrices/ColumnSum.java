package Arrays.Matrices;

public class ColumnSum {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] ans = new int[cols];

        for (int i = 0; i < cols; i++) {
            int sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += A[j][i];
            }
            ans[i] = sum;
        }

        return ans;
    }
}
