package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructionCostPrimAlgo {
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(new WeightComparator());
        int mod = 1000000007;
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[A + 1];

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int index = 0; index < B.size(); index++) {
            int source = B.get(index).get(0);
            int destination = B.get(index).get(1);
            int weight = B.get(index).get(2);

            adjacencyList.get(source).add(new Pair(destination, weight));
            adjacencyList.get(destination).add(new Pair(source, weight));
        }

        queue.add(new Pair(1, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (!visited[current.destination]) {
                visited[current.destination] = true;
                ans = (ans + current.weight) % mod;
            }

            for (Pair c : adjacencyList.get(current.destination)) {
                if (!visited[c.destination]) {
                    queue.add(new Pair(c.destination, c.weight));
                }
            }
        }

        return ans % mod;
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