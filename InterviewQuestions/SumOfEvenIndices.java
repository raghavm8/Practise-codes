package InterviewQuestions;

public class SumOfEvenIndices {
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int q = B.length;
        int[] ans = new int[q];
        int[] evenPrefix = new int[n];

        evenPrefix[0] = A[0];
        for (int i = 1; i < n; i++) {
            evenPrefix[i] = i % 2 == 0 ? evenPrefix[i - 1] + A[i] : evenPrefix[i - 1];
        }

        for (int i = 0; i < q; i++) {
            int start = B[i][0];
            int end = B[i][1];

            if (start == 0)
                ans[i] = evenPrefix[end];
            else
                ans[i] = evenPrefix[end] - evenPrefix[start - 1];
        }

        return ans;
    }
}
