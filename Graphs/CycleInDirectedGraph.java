package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        int[][] a = new int[][] { { 1, 4 }, { 2, 1 }, { 4, 3 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 1, 5 }, { 5, 3 },
                { 2, 5 }, { 5, 1 }, { 4, 2 }, { 3, 1 }, { 5, 4 }, { 3, 4 }, { 1, 3 }, { 4, 1 }, { 3, 5 }, { 3, 2 },
                { 5, 2 } };

        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(a[i][0]);
            temp.add(a[i][1]);
            B.add(temp);
        }

        System.out.println(new CycleInDirectedGraph().solve(5, B));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[A + 1];
        boolean[] path = new boolean[A + 1];

        for (int i = 0; i < A + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            adjacencyList.get(start).add(end);
        }

        for (ArrayList<Integer> c : adjacencyList) {
            for (Integer d : c) {
                System.out.print(d);
            }
            System.out.println();
        }

        for (int i = 1; i <= A; i++) {
            if (!visited[i])
                ans = isCyclePresent(path, visited, i, adjacencyList);
            if (ans == 1)
                break;
        }
        return ans;
    }

    private int isCyclePresent(boolean[] path, boolean[] visited, int i, ArrayList<ArrayList<Integer>> adjacencyList) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);

        while (!stack.isEmpty()) {
            int currents = stack.pop();

            visited[currents] = true;
            path[currents] = true;

            for (Integer integer : adjacencyList.get(currents)) {
                if (path[integer])
                    return 1;
                if (!visited[integer])
                    stack.push(integer);
            }
            // path[currents] = false;
        }
         path[i] = false;
        return 0;
    }
}
