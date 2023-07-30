package AdvancedDSA.Trees;

public class DeleteFromBST {
    public TreeNode solve(TreeNode A, int B) {
        if (A == null) {
            return null;
        }
        return getAfterDeleting(A, B);
    }

    private TreeNode getAfterDeleting(TreeNode root, int val) {
        if (root == null)
            return root;

        if (root.val > val) {
            root.left = getAfterDeleting(root.left, val);
            return root;
        } else if (root.val < val) {
            root.right = getAfterDeleting(root.right, val);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode max_left = max_left(root.left);
                root.val = max_left.val; // replace the node value with the value of a node
                // which contains the maximum value on left sub tree
                root.left = getAfterDeleting(root.left, max_left.val); // remove the node which contains
                // max value in left sub tree

            }
        }
        return root;
    }

    public static TreeNode max_left(TreeNode A) {
        while (A.right != null) {
            A = A.right;
        }
        return A;
    }
}
