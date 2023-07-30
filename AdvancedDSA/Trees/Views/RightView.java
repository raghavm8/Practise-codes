package AdvancedDSA.Trees.Views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import AdvancedDSA.Trees.TreeNode;

public class RightView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        TreeNode rightNode = A;
        while (!queue.isEmpty()) {

            TreeNode top = queue.poll();

            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);

            if (rightNode == top) {
                ans.add(top.val);
                if (!queue.isEmpty()) {
                    for (TreeNode treeNode : queue) {
                        rightNode = treeNode;
                    }
                }
            }
        }
        return ans;
    }
}
