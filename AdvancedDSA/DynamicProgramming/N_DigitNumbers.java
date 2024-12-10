package AdvancedDSA.DynamicProgramming;

import java.util.ArrayList;

public class N_DigitNumbers {
    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        int ans = 0;
        int mod = 1000000007;
        Integer[][] dp = new Integer[A + 1][B + 1];

        // for (int i = 0; i <= dp.length; i++) {
        // for (int j = 0; j <= dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }

        for (int i = 1; i <= 9; i++) {
            int numberOfDigits = A - 1;
            int sumLeft = B - i;
            ans += getNumbers(dp, numberOfDigits, sumLeft);
            ans %= mod;
        }

        return ans;
    }

    private int getNumbers(Integer[][] dp, int numberOfDigits, int sumLeft) {
        if (sumLeft < 0)
            return 0;
        if (numberOfDigits == 0 && sumLeft == 0)
            return 1;
        if (numberOfDigits == 0)
            return 0;

        if (dp[numberOfDigits][sumLeft] != null)
            return dp[numberOfDigits][sumLeft];

        int mod = 1000000007;
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            // numberOfDigits = numberOfDigits - 1;
            // sumLeft = sumLeft - i;
            ans += getNumbers(dp, numberOfDigits - 1, sumLeft - i);
            ans %= mod;
        }

        dp[numberOfDigits][sumLeft] = ans;
        return dp[numberOfDigits][sumLeft];
    }
}
