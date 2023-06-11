package AdvancedDSA.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(final int[] A) {
        int n = A.length;
        HashSet<Integer> hs = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            hs.add(A[i]);
        }

        for (Integer num : hs) {
            int tempCount = 0;
            if (hs.contains(num - 1)) {
                // tempCount++;
                continue;
            }
            // if (hs.contains(num + 1)) {
            while (hs.contains(num++)) {
                tempCount++;
            }
            // }
            ans = Math.max(ans, tempCount);
        }
        return ans;
    }
}
