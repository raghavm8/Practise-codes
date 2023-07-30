package AdvancedDSA.Trees;

public class ValidBST {
    public static void main(String[] args) {

    }

    public boolean isValidBinarySearchTree = true;

    public int isValid(TreeNode A) {
        if (A.left == null && A.right == null) {
            return 1;
        }
        return isValidBinarySearchTree ? 1 : 0;
    }

    public MaxMinPair isValidBST(TreeNode A) {
        if (A == null)
            return new MaxMinPair(Integer.MIN_VALUE, Integer.MAX_VALUE);

        MaxMinPair leftMaxMinPair = isValidBST(A.left);
        MaxMinPair rightMaxMinPair = isValidBST(A.right);

        if (leftMaxMinPair.maxVal > A.val || rightMaxMinPair.minVal < A.val)
            isValidBinarySearchTree = false;

        return new MaxMinPair(Math.max(A.val, Math.max(leftMaxMinPair.maxVal, rightMaxMinPair.maxVal)),
                Math.min(A.val, Math.min(leftMaxMinPair.minVal, rightMaxMinPair.minVal)));
    }
}

class MaxMinPair {
    int maxVal;
    int minVal;

    public MaxMinPair(int max, int min) {
        maxVal = max;
        minVal = min;
    }
}
