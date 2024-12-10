package AdvancedDSA.DynamicProgramming;

public class PalindromicSubstringsCount {
    public static void main(String[] args) {

    }

    public int solve(String A) {
        int count = 0;
        int n = A.length();
        boolean[][] isPallindrome = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len + i - 1;
                if (j >= n)
                    break;
                if (len == 1) {
                    isPallindrome[i][j] = true;
                } else if (len == 2) {
                    isPallindrome[i][j] = A.charAt(i) == A.charAt(j);
                } else {
                    isPallindrome[i][j] = A.charAt(i) == A.charAt(j) && isPallindrome[i + 1][j - 1];
                }

                if (isPallindrome[i][j])
                    count++;
            }
        }
        return count;
    }
}

class Solution {
    public int solve(String A) {
        int n = A.length();

        boolean[][] dp = new boolean[n][n];

        int cnt = 0;

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                // no need to increment i in the loop because its the beginning of the string
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                    } else
                        dp[i][j] = false;
                } else {
                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
