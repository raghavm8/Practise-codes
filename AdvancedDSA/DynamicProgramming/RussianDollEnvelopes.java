package AdvancedDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {

    }

    public int solve(int[][] A) {
        int ans = 0;
        int n = A.length;
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int[] envelopes = new int[n];

        for (int i = 0; i < n; i++) {
            envelopes[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i][0] > A[j][0] && A[i][1] > A[j][1] && envelopes[j] >= envelopes[i]) {
                    envelopes[i] += envelopes[j] + 1;
                }
            }
        }

        for (int num : envelopes) {
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
