package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);
        TreeNode lastTreeNodeOfLevel = A;
        ArrayList<Integer> aTreeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            aTreeNodes.add(top.val);

            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);

            if (top == lastTreeNodeOfLevel) {
                ans.add(aTreeNodes);
                aTreeNodes = new ArrayList<>();
                if (!queue.isEmpty())
                    for (TreeNode node : queue) {
                        lastTreeNodeOfLevel = node;
                    }
            }
        }
        return ans;
    }
}
