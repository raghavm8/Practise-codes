package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeFromInOrderAndPreOrder {

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        int n = inorder.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(inorder.get(i), i);
        }
        return Tree(inorder, preorder, 0, n - 1, 0, hm);
    }

    public static TreeNode Tree(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int start_in, int end_in,
            int start_pre, HashMap<Integer, Integer> hm) {
        if (start_in > end_in)
            return null;

        int nodeVal = preorder.get(start_pre);
        TreeNode root = new TreeNode(nodeVal);
        int index = hm.get(nodeVal);

        int countOfElementsInLeftSubtree = index - start_in;
        int countOfElementsInRightSubtree = end_in - index;

        root.left = Tree(inorder, preorder, start_in, index - 1, start_pre + 1, hm);
        root.right = Tree(inorder, preorder, index + 1, end_in, start_pre + countOfElementsInLeftSubtree + 1, hm);
        return root;
    }
}
