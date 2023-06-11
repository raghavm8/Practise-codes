package AdvancedDSA.Sorting;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1]) {
                A[i+1]++;
                ans++;
            }
        }
        return ans;
    }
}
