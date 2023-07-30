package AdvancedDSA.Trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public boolean isBalanced = true;

    public int isBalanced(TreeNode A) {
        if (A == null)
            return 0;

        int leftHeight = isBalanced(A.left);
        int rightHeight = isBalanced(A.right);

        if (Math.abs(rightHeight - leftHeight) > 1)
            isBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
