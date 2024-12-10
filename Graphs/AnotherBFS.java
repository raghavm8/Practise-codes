package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AnotherBFS {
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        int ans = -1;

        if (C == D)
            return 0;

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int newNode = A;
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            int weight = B.get(i).get(2);

            if (weight == 2) {
                adjacencyList.add(new ArrayList<>());

                adjacencyList.get(source).add(new Pair(newNode, 1));
                adjacencyList.get(newNode).add(new Pair(source, 1));

                adjacencyList.get(destination).add(new Pair(newNode, 1));
                adjacencyList.get(newNode).add(new Pair(destination, 1));
                newNode++;
            } else {
                adjacencyList.get(source).add(new Pair(destination, weight));
                adjacencyList.get(destination).add(new Pair(source, weight));
            }
        }

        boolean[] visited = new boolean[newNode + 1];
        Queue<Pair> queue = new LinkedList<>();
        visited[C] = true;
        for (Pair pair : adjacencyList.get(C)) {
            queue.add(pair);
            visited[pair.node] = true;
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.node == D)
                return current.weight;

            for (Pair pair : adjacencyList.get(current.node)) {
                if (!visited[pair.node]) {
                    visited[pair.node] = true;
                    if (pair.node == D) {
                        return current.weight + 1;
                    }
                    queue.add(new Pair(pair.node, current.weight + 1));
                }
            }
        }
        return ans;
    }

    private class Pair {
        int weight;
        int node;

        public Pair(int n, int w) {
            weight = w;
            node = n;
        }
    }
}