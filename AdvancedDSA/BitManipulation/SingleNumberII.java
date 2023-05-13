package AdvancedDSA.BitManipulation;

public class SingleNumberII {
    public static void main(String[] args) {

    }

    public int singleNumber(final int[] A) {
        int n = A.length;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((A[i] >> i) & 1) == 1)
                    count++;
            }

            if (count % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}