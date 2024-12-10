package AdvancedDSA.DynamicProgramming;

public class Stairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int A) {
        int[] ans = new int[A];
        if (A == 0)
            return 1;
        if (A <= 3)
            return A;
        ans[0] = 1;

        for (int i = 2; i < A; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[A - 1];
    }
}
