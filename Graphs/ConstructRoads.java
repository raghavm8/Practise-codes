package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructRoads {
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int mod = 1000000007;
        int ans = 0;

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }

        int[] colors = getColored(A, adjacencyList);

        long ones = 0, zeroes = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0)
                zeroes++;
            else
                ones++;
        }

        long total = (zeroes * ones) % mod;
        return (int) total - (A - 1);
    }

    private int[] getColored(int a, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] colors = new int[a + 1];
        Arrays.fill(colors, -1);

        for (int i = 0; i <= a; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                checkBipartite(colors, i, adjacencyList);
            }
        }
        return colors;
    }

    private void checkBipartite(int[] colors, int i, ArrayList<ArrayList<Integer>> adjacencyList) {
        for (Integer num : adjacencyList.get(i)) {
            if (colors[num] == -1) {
                colors[num] = 1 - colors[i];
                checkBipartite(colors, num, adjacencyList);
            } else if (colors[num] == colors[i]) {
                return;
            }
        }
    }
}