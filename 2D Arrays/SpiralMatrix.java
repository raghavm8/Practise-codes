public class SpiralMatrix {

    public static int[][] generateMatrix(int A) {
        int[][] ans = new int[A][A];
        // int rows = 0, cols = A-1;
        int n = A, r = 0, c = 0, num = 1;
        while (n > 1) {
            for (int i = 1; i < n; i++) {
                ans[r][c++] = num++;
            }
            // r++;

            for (int i = 1; i < n; i++) {
                ans[r++][c] = num++;
            }
            // c--;

            for (int i = 1; i < n; i++) {
                ans[r][c--] = num++;
            }

            for (int i = 1; i < n; i++) {
                ans[r--][c] = num++;
            }
            r++;
            c++;
            n -= 2;
        }

        if (n == 1)
            ans[r][c] = num++;

        return ans;
    }

    public static void main(String[] args) {
        int[][] ans = generateMatrix(5);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}