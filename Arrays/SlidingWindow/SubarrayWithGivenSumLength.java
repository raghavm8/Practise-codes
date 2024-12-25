package Arrays.SlidingWindow;

public class SubarrayWithGivenSumLength {
    public int solve(int[] A, int B, int C) {
        int ans = 0;
        int n = A.length;
        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        if (sum == C)
            return 1;

        for (int i = B; i < n; i++) {
            sum += A[i];
            sum -= A[i - B];
            if (sum == C)
                return 1;
        }
        return ans;
    }
}
