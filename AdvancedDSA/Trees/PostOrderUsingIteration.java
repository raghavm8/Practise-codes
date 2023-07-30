package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderUsingIteration {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(A);
        TreeNode topNode = A;
        while (!stack.isEmpty()) {
            if (topNode != null) {
                stack.push(topNode);
                ans.add(topNode.val);
                topNode = topNode.right;
            } else {
                topNode = stack.pop();
                topNode = topNode.left;
            }
        }
        Collections.reverse(ans);

        return ans;
    }
}