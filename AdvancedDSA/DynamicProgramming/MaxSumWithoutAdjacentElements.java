package AdvancedDSA.DynamicProgramming;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {

    }

    public int adjacent(int[][] A) {
        int rows = 2;
        int cols = A[0].length;
        int[] possibleNumbers = new int[cols];
        int sum = 0;

        if (cols == 1) {
            return Math.max(A[0][0], A[1][0]);
        }

        for (int i = 0; i < cols; i++) {
            possibleNumbers[i] = Math.max(A[0][i], A[1][i]);
        }

        int[] ans = new int[cols];
        ans[0] = possibleNumbers[0];
        ans[1] = Math.max(possibleNumbers[0], possibleNumbers[1]);
        for (int i = 2; i < cols; i++) {
            ans[i] = Math.max(possibleNumbers[i] + ans[i - 2], ans[i - 1]);
        }

        return ans[cols - 1];
    }

    public int adjacentCarryForward(int[][] A) {
        int cols = A[0].length;
        int sum = 0;

        if (cols == 1) {
            return Math.max(A[0][0], A[1][0]);
        }

        int first = Math.max(A[0][0], A[1][0]);
        int second = Math.max(Math.max(A[0][1], A[1][1]), first);
        sum = second;
        for (int i = 2; i < cols; i++) {
            int currentMax = Math.max(A[0][i], A[1][i]);

            sum = Math.max(currentMax + first, second);
            first = second;
            second = sum;
        }
        return sum;
    }
}