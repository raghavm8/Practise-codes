package Hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {

    }

    public int solve(int[] a) {
        int n = a.length;
        int[] prefixArray = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        prefixArray[0] = a[0];
        for (int i = 0; i < n; i++) {
            prefixArray[i] = prefixArray[i - 1] + a[i];
            if (prefixArray[i] == 0)
                return 1;
        }

        for (int i = 0; i < n; i++) {
            if (hs.contains(prefixArray[i]) || prefixArray[i] == 0)
                return 1;
            else
                hs.add(prefixArray[i]);
        }

        return 0;
    }
}
