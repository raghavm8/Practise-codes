package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathInDirectedGraph {
    public static void main(String[] args) {
        // int[][] a = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 3 } };
        int n = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        // 1->2->3<-4

        a.add(1);
        a.add(2);
        b.add(1);
        b.add(2);
        c.add(1);
        c.add(2);

        B.add(a);
        B.add(b);
        B.add(c);

        System.out.println(new PathInDirectedGraph().solve_DFS(n, B));
    }

    public int solve_BFS(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        int edges = B.size();

        ArrayList<Integer>[] adjacencyList = new ArrayList[A + 1];
        for (int i = 1; i < A + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            adjacencyList[start].add(end);
        }

        boolean[] visited = new boolean[A + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (queue.size() > 0) {
            int currentNode = queue.poll();
            if (currentNode == A)
                ans = 1;

            for (int i = 0; i < adjacencyList[currentNode].size(); i++) {
                int node = adjacencyList[currentNode].get(i);
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

        return ans;
    }

    public int solve_DFS(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        int edges = B.size();

        ArrayList<Integer>[] adjacencyList = new ArrayList[A + 1];
        for (int i = 1; i < A + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            adjacencyList[start].add(end);
        }

        boolean[] visited = new boolean[A + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (currentNode == A) {
                ans = 1;
            }

            if (!visited[currentNode]) {
                visited[currentNode] = true;
            }

            for (Integer currentNumber : adjacencyList[currentNode]) {
                if (!visited[currentNumber])
                    stack.push(currentNumber);
            }
        }
        return ans;
    }
}
