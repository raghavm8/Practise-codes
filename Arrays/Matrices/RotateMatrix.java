package Arrays.Matrices;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };

        print(matrix);
        System.out.println();
        solve(matrix);
    }

    public static void solve(int[][] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = t;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
        }

        print(A);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
