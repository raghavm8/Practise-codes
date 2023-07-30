package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);
        int levelDirection = 1;
        TreeNode lastNode = A;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            temp.add(top.val);

            if (top.right != null)
                queue.add(top.right);
            if (top.left != null)
                queue.add(top.left);
            
            if (top == lastNode) {
                Collections.reverse(temp);
                ans.add(temp);
                temp = new ArrayList<>();
                levelDirection++;
                if (!queue.isEmpty()) {
                    for (TreeNode node : queue) {
                        lastNode = node;
                    }
                }
            }
        }

        return ans;
    }
}
