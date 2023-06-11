package AdvancedDSA.Hashing;

import java.util.HashMap;

public class ShaggyAndDistances {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        int ans = Integer.MAX_VALUE;
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(A[i])) {
                int distance = i - hm.get(A[i]);
                hm.remove(A[i]);
                hm.put(A[i], i);
                ans = Math.min(ans, distance);
            } else {
                hm.put(A[i], i);
            }
        }
        return ans;
    }
}