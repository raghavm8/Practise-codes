public class AntiDiagonals {
    public static int[][] diagonal(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] ans = new int[rows + cols - 1][cols];

        for (int i = 0; i < ans.length; i++)
            for (int j = 0; j < ans[0].length; j++)
                ans[i][j] = 0;

        int ansRows = 0;
        int ansCols = 0;
        for (int i = 0; i < cols; i++) {
            int row = 0, col = i;
            ansCols = 0;
            while (row < rows && col >= 0) {
                ans[ansRows][ansCols] = a[row][col];
                row++;
                col--;
                ansCols++;
            }
            ansRows++;
        }

        for (int i = 1; i < rows; i++) {
            int row = i, col = cols - 1;
            ansCols = 0;
            while (row < rows && col >= 0) {
                ans[ansRows][ansCols] = a[row][col];
                col--;
                ansCols++;
                row++;
            }
            ansRows++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] ans = new int[5][3];

        ans = diagonal(a);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
