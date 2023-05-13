package InterviewQuestions;

public class SpecialIndex {
    public static int solve(int[] a) {
        int n = a.length;
        int ans = 0;
        int[] even = new int[n];
        int[] odd = new int[n];

        even[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0)
                even[i] = a[i] + even[i - 1];
            else
                even[i] = even[i - 1];
        }

        odd[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1)
                odd[i] = a[i] + odd[i - 1];
            else
                odd[i] = odd[i - 1];
        }

        int evenSum = even[n - 1];
        int oddSum = odd[n - 1];
        if (oddSum == evenSum)
            ans++;
        for (int i = 1; i < n; i++) {
            evenSum = even[i - 1] + (odd[n - 1] - odd[i]);
            oddSum = odd[i - 1] + (even[n - 1] - even[i]);

            if (evenSum == oddSum)
                ans++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 7, 1, 2, 3 }; // even odd
        // -, 2, 3, 7, 1, 2, 3                  11 7
        // 1, -, 3, 7, 1, 2, 3                  10 7
        // 1, 2, -, 7, 1, 2, 3                  10 6
        // 1, 2, 3, -, 1, 2, 3                  6 6
        // 1, 2, 3, 7, -, 2, 3
        // 1, 2, 3, 7, 1, -, 3
        // 1, 2, 3, 7, 1, 2, -

        int ans = solve(a);
        System.out.println(ans);
    }
}