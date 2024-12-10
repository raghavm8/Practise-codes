package AdvancedDSA.DynamicProgramming;

import java.util.Arrays;

public class CoinSumInfinite {
    public static void main(String[] args) {

    }

    // ordered
    public int _coinchange2(int[] A, int B) {
        int n = A.length;
        int[] coins = new int[B + 1];

        for (int i = 1; i <= B; i++) {
            coins[i] = 0;
            for (int j = 0; j < n; j++) {
                if (i >= A[j]) {
                    coins[i] += coins[i - A[j]];
                }
            }
        }
        return coins[B];
    }

    // unordered
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[] coins = new int[B + 1];
        Arrays.fill(coins, 0);
        int mod = 1000000007;

        coins[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= B; j++) {
                if (A[i] <= j) {
                    coins[j] += coins[j - A[i]];
                    coins[j]%=mod;
                }
            }
        }
        return coins[B];
    }
}
