package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijsktra {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<Integer> ans = new ArrayList<>(A);
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new WeightComparator());

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            int weight = B.get(i).get(2);

            adjacencyList.get(source).add(new Pair(destination, weight));
            adjacencyList.get(destination).add(new Pair(source, weight));
        }

        for (int i = 0; i < A; i++) {
            ans.add(Integer.MAX_VALUE);
        }
        ans.set(C, 0);
        queue.add(new Pair(C, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (ans.get(current.destination) < current.weight)
                continue;
            else {
                for (Pair pair : adjacencyList.get(current.destination)) {
                    int weight = pair.weight;
                    int destinationNode = pair.destination;

                    if (ans.get(destinationNode) > weight + ans.get(current.destination)) {
                        ans.set(destinationNode, weight + ans.get(current.destination));
                        queue.add(new Pair(destinationNode, weight));
                    }
                }
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) == Integer.MAX_VALUE)
                ans.set(i, -1);
        }

        return ans;
    }

    private class Pair {
        int destination;
        int weight;

        public Pair(int d, int w) {
            destination = d;
            weight = w;
        }
    }

    private class WeightComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }
    }
}
