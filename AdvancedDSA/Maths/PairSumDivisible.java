package AdvancedDSA.Maths;

public class PairSumDivisible {
    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        int n = A.length;
        long ans = 0;
        long[] mods = new long[B];

        for (int i = 0; i < n; i++)
            mods[A[i] % B]++;

        ans = ans + ((mods[0] * (mods[0] - 1))) / 2;
        if (B % 2 == 0) {
            int index = B / 2;
            ans = ans + ((mods[index] * (mods[index] - 1))) / 2;
        }

        // // int limit = (int) Math.ceil(B / 2) - 1;
        // for (int i = 1; i < Math.ceil(B / 2) - 1; i++) {
        // ans += mods[i] * mods[B - i];
        // }

        int i = 1;
        int j = B - 1;
        while (i < j) {
            ans += mods[i] * mods[j];
            i++;
            j--;
        }
        return (int) (ans % 1000000007);
    }
}