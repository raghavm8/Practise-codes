package AdvancedDSA.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber {
    public static void main(String[] args) {

    }

    public int colorful(int A) {
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        String num = String.valueOf(A);
        int n = num.length();

        for (int i = 0; i < n; i++)
            list.add(Character.getNumericValue(num.charAt(i)));

        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = i; j < n; j++) {
                temp *= list.get(j);
                if (hs.contains(temp))
                    return 0;
                hs.add(temp);
            }
        }

        return ans;
    }
}
