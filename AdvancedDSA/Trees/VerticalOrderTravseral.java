package AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTravseral {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(123);
        A.right = new TreeNode(994);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        queue.add(new Pair(A, 0));
        ArrayList<Integer> rootVal = new ArrayList<>();
        rootVal.add(A.val);
        hm.put(0, rootVal);

        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            minDistance = Math.min(minDistance, top.distance);
            maxDistance = Math.max(maxDistance, top.distance);

            if (top.node.left != null) {
                int dist = top.distance - 1;
                ArrayList<Integer> elementsAtThisDistance = new ArrayList<>();
                if (hm.containsKey(dist)) {
                    elementsAtThisDistance = hm.get(dist);
                    elementsAtThisDistance.add(top.node.left.val);
                    hm.remove(dist);
                    hm.put(dist, elementsAtThisDistance);
                } else {
                    elementsAtThisDistance.add(top.node.left.val);
                    hm.put(dist, elementsAtThisDistance);
                }
                queue.add(new Pair(top.node.left, dist));
            }

            if (top.node.right != null) {
                int dist = top.distance + 1;
                ArrayList<Integer> elementsAtThisDistance = new ArrayList<>();
                if (hm.containsKey(dist)) {
                    elementsAtThisDistance = hm.get(dist);
                    elementsAtThisDistance.add(top.node.right.val);
                    hm.remove(dist);
                    hm.put(dist, elementsAtThisDistance);
                } else {
                    elementsAtThisDistance.add(top.node.right.val);
                    hm.put(dist, elementsAtThisDistance);
                }
                queue.add(new Pair(top.node.right, dist));
            }
        }

        for (int i = minDistance; i <= maxDistance; i++) {
            if (hm.containsKey(i) == false)
                continue;
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer num : hm.get(i)) {
                temp.add(num);
            }
            ans.add(temp);
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
