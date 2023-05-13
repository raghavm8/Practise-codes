public class MatrixTranspose {
    public static int[][] solve(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        int[][] ans = new int[cols][rows];
        int ansRows = 0, ansCols = 0;
        for (int i = 0; i < rows; i++) {
            ansRows = 0;
            for (int j = 0; j < cols; j++) {
                ans[ansRows][ansCols] = a[i][j];
                ansRows++;
            }
            ansCols++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 } };
        int[][] ans = new int[5][3];

        ans = solve(a);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}