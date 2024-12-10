package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class FirstDepthFirstSearch {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 1, 1, 3, 3, 2, 2, 7, 6 };
        int b = 6;
        int c = 5;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i : a) {
            arrayList.add(i);
        }
        System.out.println("ans = " + new FirstDepthFirstSearch().solve(arrayList, b, c));
    }

    public int solve(ArrayList<Integer> A, final int B, final int C) {
        int ans = 0;
        int n = A.size();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adjacencyList.get(A.get(i)).add(i + 1);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(C);
        boolean[] visited = new boolean[n + 1];
        visited[C] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (!visited[currentNode]) {
                System.out.print(currentNode + " -> ");
                visited[currentNode] = true;
            }

            if (currentNode == B)
                ans = 1;

            for (Integer currentNumber : adjacencyList.get(currentNode)) {
                if (!visited[currentNumber])
                    stack.push(currentNumber);
            }
        }
        return ans;
    }
}
