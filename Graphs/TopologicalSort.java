package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
// import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        int[][] a = new int[][] { { 1, 4 }, { 1, 2 }, { 4, 2 }, { 4, 3 }, { 3, 2 }, { 5, 2 }, { 3, 5 }, { 8, 2 },
                { 8, 6 } };

        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(a[i][0]);
            temp.add(a[i][1]);
            B.add(temp);
        }

        System.out.println(new TopologicalSort().solve(8, B));
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int[] indegree = new int[A + 1];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            adjacencyList.get(start).add(end);
        }

        for (int i = 0; i < adjacencyList.size(); i++) {
            ArrayList<Integer> list = adjacencyList.get(i);
            for (int index : list) {
                indegree[index]++;
            }
        }

        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int zeroIndegreeNode = queue.remove();
            ans.add(zeroIndegreeNode);

            for (Integer node : adjacencyList.get(zeroIndegreeNode)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return ans.size() != A ? new ArrayList<>() : ans;
    }

    // public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    // ArrayList<Integer> ans = new ArrayList<>();
    // boolean[] visited = new boolean[A + 1];
    // ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    // for (int i = 0; i <= A; i++) {
    // adjacencyList.add(new ArrayList<Integer>());
    // }

    // for (int i = 0; i <= A; i++) {
    // int start = B.get(i).get(0);
    // int end = B.get(i).get(1);
    // adjacencyList.get(start).add(end);
    // }

    // for (int i = 1; i <= A; i++) {
    // if (!visited[i])
    // getTopologicalOrder(visited, ans, adjacencyList, i);
    // }

    // return ans;
    // }

    // private void getTopologicalOrder(boolean[] visited, ArrayList<Integer> ans,
    // ArrayList<ArrayList<Integer>> adjacencyList, int node) {
    // Stack<Integer> stack = new Stack<>();
    // stack.push(node);

    // // while (!stack.isEmpty()) {
    // int currentNode = stack.pop();
    // if (!visited[currentNode]) {
    // visited[currentNode] = true;
    // }

    // for (Integer num : adjacencyList.get(currentNode)) {
    // if (!visited[num])
    // getTopologicalOrder(visited, ans, adjacencyList, num);
    // }
    // ans.add(currentNode);
    // // }
    // }

    // private void getTopologicalOrder(boolean[] visited, ArrayList<Integer> ans,
    // ArrayList<ArrayList<Integer>> adjacencyList, int node) {
    // Stack<Integer> stack = new Stack<>();
    // stack.push(node);

    // while (!stack.isEmpty()) {
    // int currentNode = stack.pop();
    // if (!visited[currentNode]) {
    // visited[currentNode] = true;
    // }

    // for (Integer num : adjacencyList.get(currentNode)) {
    // if (!visited[num])
    // stack.push(num);
    // }
    // ans.add(currentNode);
    // }
    // }
}