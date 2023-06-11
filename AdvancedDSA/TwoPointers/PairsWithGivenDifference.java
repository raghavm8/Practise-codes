package AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        // int[] a = new int[] { 1, 100000 };
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        // a.add(1);
        // a.add(1);
        // a.add(2);
        a.add(2);
        System.out.println(solve(a, 0));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int l = 0, r = 1;
        Collections.sort(A);
        while (r < A.size()) {
            int left = A.get(l);
            int right = A.get(r);
            int diff = right - left;
            if (diff == B) {
                int countofLeftToRight = 0;
                int countofRightToLeft = 0;

                if (left == right) {
                    int k = r;
                    while (r < A.size()) {
                        r++;
                        if (A.get(k++) != right) {
                            break;
                        }
                    }
                    count++;
                    continue;
                }
                for (int j = l; j <= r; j++) {
                    if (A.get(j) == left)
                        countofLeftToRight++;
                    else
                        break;
                }
                for (int j = r; j >= l; j--) {
                    if (A.get(j) == right)
                        countofRightToLeft++;
                    else
                        break;
                }
                count++;
                l += countofLeftToRight;
                r -= countofRightToLeft;
            } else if (diff > B) {
                l++;
                if (l == r)
                    r++;
            } else
                r++;
        }
        return count;
    }
}
