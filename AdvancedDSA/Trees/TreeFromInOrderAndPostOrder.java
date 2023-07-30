package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeFromInOrderAndPostOrder {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        int n = inorder.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(inorder.get(i), i);
        }
        return Tree(inorder, postorder, 0, n - 1, n - 1, hm);
    }

    public static TreeNode Tree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start_in, int end_in,
            int end_post, HashMap<Integer, Integer> hm) {
        if (start_in > end_in)
            return null;

        int nodeVal = postorder.get(end_post);
        TreeNode root = new TreeNode(nodeVal);
        int index = hm.get(nodeVal);
        int countOfElementsInRightSubtree = end_in - index;

        root.left = Tree(inorder, postorder, start_in, index - 1, end_post - countOfElementsInRightSubtree - 1, hm);
        root.right = Tree(inorder, postorder, index + 1, end_in, end_post - 1, hm);

        return root;
    }
}