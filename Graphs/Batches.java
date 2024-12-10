package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Batches {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];
        int count = 0;
        int batchStrength = 0;

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < C.size(); i++) {
            int node1 = C.get(i).get(0);
            int node2 = C.get(i).get(1);
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        queue.add(1);
        visited[1] = true;
        batchStrength = B.get(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer num : adjacencyList.get(current)) {
                if (!visited[num]) {
                    visited[num] = true;
                    batchStrength += B.get(num - 1);
                    queue.add(num);
                }
            }

            if (queue.isEmpty()) {
                if (batchStrength >= D) {
                    count++;
                }

                for (int i = 1; i <= A; i++) {
                    if (!visited[i]) {
                        queue.add(i);
                        batchStrength = B.get(i - 1);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
