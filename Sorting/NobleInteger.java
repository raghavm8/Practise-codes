package Sorting;

import java.util.Arrays;

public class NobleInteger {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int ans = 0;

        
        for (int i = 0; i < n - 1; i++) {
            int num = A[n - i - 1];
            if (num != A[n - i]) {
                ans = i;
            }

            if (num == ans)
                ans++;
        }

        return ans == 0 ? -1 : ans;
    }
}
