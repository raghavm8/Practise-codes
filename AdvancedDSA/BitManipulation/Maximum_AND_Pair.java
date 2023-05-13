package AdvancedDSA.BitManipulation;

public class Maximum_AND_Pair {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += (A[i] >> i) & 1;
            }

            if (count >= 2) {
                for (int j = 0; j < n; j++) {
                    ans |= 1 << i;
                    if (((A[i] >> i) & 1) == 0) {
                        A[i] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
