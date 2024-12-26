package InterviewQuestions;

public class SumOfOddIndices {
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int q = B.length;
        int[] ans = new int[q];
        int[] oddPrefix = new int[n];

        oddPrefix[0] = 0;
        for (int i = 1; i < n; i++) {
            oddPrefix[i] = i % 2 == 1 ? oddPrefix[i - 1] + A[i] : oddPrefix[i - 1];
        }

        for (int i = 0; i < q; i++) {
            int start = B[i][0];
            int end = B[i][1];

            if (start == 0)
                ans[i] = oddPrefix[end];
            else
                ans[i] = oddPrefix[end] - oddPrefix[start - 1];
        }

        return ans;
    }
}
