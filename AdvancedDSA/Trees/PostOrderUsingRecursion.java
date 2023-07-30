package AdvancedDSA.Trees;

public class PostOrderUsingRecursion {
    public static void main(String[] args) {

    }

    public void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}
