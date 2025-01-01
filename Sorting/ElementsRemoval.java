package Sorting;

import java.util.Arrays;

public class ElementsRemoval {
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            int num = A[n - i - 1];
            ans = ans + (i + 1);
        }

        return ans;
    }
}

// 4 5 6 7 8 9
// 9 8 7 6 5 4
// 8 7 6 5 4
// 7 6 5 4
// 6 5 4
// 5 4
// 4