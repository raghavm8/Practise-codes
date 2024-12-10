package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructionCost {
    public static void main(String[] args) {

    }


    // kruskal's algorithm
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        PriorityQueue<Triplet> queue = new PriorityQueue<>(new WeightComparator());
        int[] parent = new int[A + 1];
        int mod = 1000000007;

        for (int i = 0; i < B.size(); i++) {
            Triplet p = new Triplet(B.get(i).get(0), B.get(i).get(1), B.get(i).get(2));
            queue.add(p);
        }

        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        while (!queue.isEmpty()) {
            Triplet current = queue.poll();
            boolean notInCycle = union(current.point1, current.point2, parent);
            if (notInCycle)
                ans = (ans + current.weight) % mod;
        }

        return ans % mod;
    }

    private boolean union(int point1, int point2, int[] parent) {
        int root1 = root(point1, parent);
        int root2 = root(point2, parent);

        if (root1 == root2)
            return false;

        parent[root1] = root2;
        return true;
    }

    private int root(int x, int[] parent) {
        if (parent[x] == x)
            return x;

        int r = root(parent[x], parent);
        parent[x] = r;
        return r;
    }

    private class Triplet {
        int point1;
        int point2;
        int weight;

        public Triplet(int p1, int p2, int w) {
            point1 = p1;
            point2 = p2;
            weight = w;
        }
    }

    private class WeightComparator implements Comparator<Triplet> {
        @Override
        public int compare(Triplet o1, Triplet o2) {
            return o1.weight - o2.weight;
        }
    }
}
