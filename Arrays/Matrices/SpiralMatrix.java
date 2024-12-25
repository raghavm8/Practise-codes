package Arrays.Matrices;

public class SpiralMatrix {
    public int[][] generateMatrix(int A) {
        int[][] ans = new int[A][A];

        int top = 0, left = 0;
        int bottom = A - 1, right = A - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i < right; i++) {
                ans[top][i] = num++;
            }
            top++;

            for (int i = top; i < bottom; i++) {
                ans[i][right] = num++;
            }
            right--;

            if (left <= right) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
            }

            if (top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }

                left++;
            }
        }

        return ans;
    }
}
