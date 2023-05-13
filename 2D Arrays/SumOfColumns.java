public class SumOfColumns {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] ans = new int[cols];
        int iterator = 0;

        for (int i = 0; i < cols; i++) {
            int sum = 0;
            for (int j = 0; j < rows; i++) {
                sum += A[j][i];
            }
            ans[iterator++] = sum;
        }
        return ans;
    }
}