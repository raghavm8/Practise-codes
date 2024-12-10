package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int ans = -1;
        int n = A.size();
        int m = A.get(0).size();
        int[] x = new int[] { 1, -1, 0, 0 };
        int[] y = new int[] { 0, 0, 1, -1 };
        Queue<Pair> queue = new LinkedList<>();
        int[][] time = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 2) {
                    queue.add(new Pair(i, j));
                    time[i][j] = 0;
                } else
                    time[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            for (int j = 0; j < 4; j++) {
                int a = pair.start + x[j];
                int b = pair.end + y[j];
                if (a >= 0 && b >= 0 && a < n && b < m && A.get(a).get(b) == 1 && time[a][b] != Integer.MAX_VALUE) {
                    A.get(a).set(b, 2);
                    time[a][b] = time[pair.start][pair.end] + 1;
                    queue.add(new Pair(a, b));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    return -1;
                }
                if (time[i][j] != Integer.MAX_VALUE)
                    ans = Math.max(ans, time[i][j]);
            }
        }
        return ans;
    }

    private class Pair {
        int start;
        int end;

        public Pair(int s, int e) {
            start = s;
            end = e;
        }
    }
}