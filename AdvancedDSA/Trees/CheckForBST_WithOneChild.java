package AdvancedDSA.Trees;

public class CheckForBST_WithOneChild {
    public static void main(String[] args) {

    }

    public String solve(int[] A) {
        int n = A.length;
        int root = A[0];

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            root = A[i - 1];
            if (A[i] > root) {
                min = root;
            } else {
                max = root;
            }
            // root = A[i];
            if (A[i] > max || A[i] < min)
                return "NO";
        }
        return "YES";
    }
}