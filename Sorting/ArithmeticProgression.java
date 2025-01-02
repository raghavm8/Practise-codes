package Sorting;

import java.util.Arrays;

public class ArithmeticProgression {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);

        int cd = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            if (diff != cd)
                return 0;
        }

        return 1;
    }
}
