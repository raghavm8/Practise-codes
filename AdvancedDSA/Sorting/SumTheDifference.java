package AdvancedDSA.Sorting;

import java.util.Arrays;

public class SumTheDifference {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        int n = A.length;
        long ans = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            int countOfLesserElements = i;
            int countOfGreaterElements = n - i - 1;
            long max = (long) (Math.pow(2, countOfLesserElements) % mod);
            long min = (long) (Math.pow(2, countOfGreaterElements) % mod);

            ans = (ans + (A[i] * (max - min + mod) % mod) % mod) % mod;
        }
        
        return (int) ans;
    }
}
