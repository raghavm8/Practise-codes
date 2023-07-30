package AdvancedDSA.Trees;

public class PreOrderUsingRecursion {
    public static void main(String[] args) {

    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
