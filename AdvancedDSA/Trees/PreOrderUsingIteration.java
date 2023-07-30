package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderUsingIteration {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = A;
        while (curr != null || stack.isEmpty() == false) {

            TreeNode top = stack.pop();
            ans.add(top.val);

            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
        }
        return ans;
    }
}
