package AdvancedDSA.BitManipulation;

public class SingleNumberIII {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int n = A.length;
        int[] ans = new int[2];

        int xorOfUniqueNumbers = 0;
        for (int i = 0; i < n; i++) {
            xorOfUniqueNumbers ^= A[i];
        }

        int bitNumber = 0;
        for (int i = 0; i < 31; i++) {
            if (((xorOfUniqueNumbers >> i) & 1) == 1) {
                bitNumber = i;
                break;
            }
        }

        ans[0] = 0;
        ans[1] = 0;
        for (int i = 0; i < n; i++) {
            if (((A[i] >> bitNumber) & 1) == 1)
                ans[0] ^= A[i];
            else
                ans[1] ^= A[i];
        }
        return ans;
    }
}