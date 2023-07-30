package AdvancedDSA.Trees.Views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import AdvancedDSA.Trees.TreeNode;

public class TopView {
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        queue.add(new Pair(A, 0));
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(A.val);
        hm.put(0, temp);
        while (!queue.isEmpty()) {
            Pair topNodePair = queue.poll();
            minDistance = Math.min(minDistance, topNodePair.distance);
            maxDistance = Math.max(maxDistance, topNodePair.distance);

            if (topNodePair.node.left != null) {
                int distance = topNodePair.distance - 1;
                ArrayList<Integer> elementsOnThisDistance = new ArrayList<>();
                if (hm.containsKey(distance)) {
                    elementsOnThisDistance = hm.get(distance);
                    elementsOnThisDistance.add(topNodePair.node.left.val);
                    hm.remove(distance);
                    hm.put(distance, elementsOnThisDistance);
                } else {
                    elementsOnThisDistance.add(topNodePair.node.left.val);
                    hm.put(distance, elementsOnThisDistance);
                }
                queue.add(new Pair(topNodePair.node.left, distance));
            }
            if (topNodePair.node.right != null) {
                int distance = topNodePair.distance + 1;
                ArrayList<Integer> elementsOnThisDistance = new ArrayList<>();
                if (hm.containsKey(distance)) {
                    elementsOnThisDistance = hm.get(distance);
                    elementsOnThisDistance.add(topNodePair.node.right.val);
                    hm.remove(distance);
                    hm.put(distance, elementsOnThisDistance);
                } else {
                    elementsOnThisDistance.add(topNodePair.node.right.val);
                    hm.put(distance, elementsOnThisDistance);
                }
                queue.add(new Pair(topNodePair.node.right, distance));
            }
        }

        for (int i = minDistance; i <= maxDistance; i++) {
            if (!hm.containsKey(i))
                continue;
            for (Integer nodeVal : hm.get(i)) {
                ans.add(nodeVal);
                break;
            }
        }
        return ans;
    }
}

class Pair {
    public TreeNode node;
    public int distance;

    public Pair(TreeNode node, int x) {
        this.node = node;
        distance = x;
    }
}
