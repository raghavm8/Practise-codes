package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartiteGraph {
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int[] colors = new int[A];

        for (int i = 0; i < A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }

        Arrays.fill(colors, -1);

        for (int i = 0; i < A; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                boolean check = checkBipartite(adjacencyList, colors, i);
                if (!check)
                    return 0;
            }
        }
        return 1;
    }

    private boolean checkBipartite(ArrayList<ArrayList<Integer>> adjacencyList, int[] colors, int source) {
        for (int num : adjacencyList.get(source)) {
            if (colors[num] == -1) {
                colors[num] = 1 - colors[source];
                if (!checkBipartite(adjacencyList, colors, num))
                    return false;
            } else if (colors[source] == colors[num]) {
                return false;
            }
        }
        return true;
    }
}
