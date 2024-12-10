package AdvancedDSA.DynamicProgramming;

public class MinimumNumberOfSquares {
    public static void main(String[] args) {

    }

    public int countMinSquares(int A) {
        int[] ans = new int[A + 1];
        ans[0] = 0;
        
        for (int i = 1; i <= A; i++) {
            ans[i] = i;
            for (int x = 1; x * x <= i; x++) {
                ans[i] = Math.min(ans[i], 1 + ans[A - (x * x)]);
            }
        }
        return ans[A];
    }
}
