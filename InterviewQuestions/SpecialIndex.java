package InterviewQuestions;

public class SpecialIndex {
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];
        evenPrefix[0] = A[0];
        oddPrefix[0] = 0;

        for (int i = 1; i < n; i++) {
            evenPrefix[i] = i % 2 == 0 ? evenPrefix[i - 1] + A[i] : evenPrefix[i - 1];
        }

        for (int i = 1; i < n; i++) {
            oddPrefix[i] = i % 2 == 1 ? oddPrefix[i - 1] + A[i] : oddPrefix[i - 1];
        }

        if (evenPrefix[n - 1] == oddPrefix[n - 1])
            ans++;

        for (int i = 1; i < n; i++) {
            int evenSum = evenPrefix[i - 1] + (oddPrefix[n - 1] - oddPrefix[i]);
            int oddSum = oddPrefix[i - 1] + (evenPrefix[n - 1] - evenPrefix[i]);

            if (evenSum == oddSum)
                ans++;
        }

        return ans;
    }
}
