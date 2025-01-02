package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] A) {
        int n = A.length;
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.toString(A[i]);
        }

        Arrays.sort(a, factors);

        if(a[0].charAt(n) == '0'){
            return "0";
        }

        String ans = "";
        for (String string : a) {
            ans += string;
        }
        return ans;

    }

    private static Comparator factors = new Comparator<String>() {
        public int compare(String a, String b) {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    };
}
