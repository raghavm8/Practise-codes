package AdvancedDSA.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class B_ClosestPointsToOrigin {
    public static void main(String[] args) {

    }

    public <T> int[][] solve(int[][] A, int B) {
        int[][] ans = new int[B][2];
        int n = A.length;

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                double a = getDistance(o1[0], o1[1]);
                double b = getDistance(o2[0], o2[1]);

                if (a < b) {
                    return 1;
                } else if (a > b) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < B; i++) {
            int x = A[i][0];
            int y = A[i][1];

            ans[i][0] = x;
            ans[i][1] = y;
        }
        return ans;
    }

    public static int getDistance(int x, int y) {
        return x * x + y * y;
    }
}

// Arrays.sort(A, new Comparator<int[]>() {
// @Override
// public int compare(int[] o1, int[] o2) {
// if (o1[0] > o2[0]) {
// return 1;
// } else if (o1[0] < o2[0]) {
// return -1;
// } else {
// if (o1[1] > o2[1]) {
// return 1;
// } else if (o1[1] < o2[1]) {
// return -1;
// } else {
// return 0;
// }
// }
// }
// });