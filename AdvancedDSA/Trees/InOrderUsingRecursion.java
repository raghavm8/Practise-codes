package AdvancedDSA.Trees;

public class InOrderUsingRecursion {
    public static void main(String[] args) {

    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}