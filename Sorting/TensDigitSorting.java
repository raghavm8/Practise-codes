package Sorting;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TensDigitSorting {
    public int[] solve(int[] A) {
        int n = A.length;
        int ans = 0;

        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = A[i];
        }

        Arrays.sort(a, digitsComparator);

        for (int i = 0; i < n; i++) {
            A[i] = a[i];
        }
        return A;
    }

    private static Comparator digitsComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int f1 = GetDigitAtTensPlace(o1);
            int f2 = GetDigitAtTensPlace(o2);

            if (f1 == f2)
                return Integer.compare(o2, o1);
            else
                return Integer.compare(f1, f2);
        }
    };

    public static int GetDigitAtTensPlace(int n) {
        n = n % 100;
        n = n / 10;
        return n;
    }
}
