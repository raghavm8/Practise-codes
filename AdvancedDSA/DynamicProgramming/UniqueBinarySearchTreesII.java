package AdvancedDSA.DynamicProgramming;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {

    }

    public int numTrees(int A) {
        int[] ans = new int[A + 1];

        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= A; i++) {
            int total = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                total += ans[left] * ans[right];
            }
            ans[i] = total;
        }
        return ans[A];
    }

}