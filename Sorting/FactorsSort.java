package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class FactorsSort {
    public int[] solve(int[] A) {
        Integer[] arr = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, factors);

        for (int i = 0; i < arr.length; i++) {
            A[i] = arr[i];
        }

        return A;
    }

    private static int GetNumberOfFactors(int n) {
        int count = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    private static Comparator factors = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int f1 = GetNumberOfFactors(o1);
            int f2 = GetNumberOfFactors(o2);

            if (f1 == f2)
                return Integer.compare(o1, o2);
            else
                return Integer.compare(f1, f2);
        }
    };
}
