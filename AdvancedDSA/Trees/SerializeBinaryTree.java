package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode topNode = queue.poll();
            ans.add(topNode.val);

            if (topNode.left != null)
                queue.add(topNode.left);
            else if (topNode.val != -1)
                queue.add(new TreeNode(-1));
            if (topNode.right != null)
                queue.add(topNode.right);
            else if (topNode.val != -1)
                queue.add(new TreeNode(-1));
        }
        return ans;
    }
}