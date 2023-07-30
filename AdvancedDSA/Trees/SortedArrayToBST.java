package AdvancedDSA.Trees;

import java.util.List;

public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        int n = A.size();
        return getTree(A, 0, n - 1);
    }

    private TreeNode getTree(List<Integer> arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = getTree(arr, start, mid - 1);
        root.right = getTree(arr, mid + 1, end);

        return root;
    }
}
