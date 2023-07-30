package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderUsingIteration {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = A;
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.peek();
                arr.add(curr.val);
                stack.pop();
                curr = curr.right;
            }
        }
        return arr;
    }
}
