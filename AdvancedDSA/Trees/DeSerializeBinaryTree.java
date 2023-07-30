package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeSerializeBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        int n = A.size();
        Queue<TreeNode> queue = new LinkedList<>();

        int i = 1;
        queue.add(new TreeNode(A.get(0)));
        TreeNode headNode = queue.peek();
        while (!queue.isEmpty() && i < n) {
            TreeNode topNode = queue.poll();

            if (A.get(i) != -1) {
                topNode.left = new TreeNode(A.get(i));
                queue.add(topNode.left);
            }
            i++;

            if (A.get(i) != -1) {
                topNode.right = new TreeNode(A.get(i));
                queue.add(topNode.right);
            }
            i++;
        }
        return headNode;
    }
}
