package AdvancedDSA.Maths;

import java.util.ArrayList;

public class Compute_nCr_Modm {
    public static void main(String[] args) {
        System.out.println(solve2D(5, 2, 13));
    }

    public static int solve(int A, int B, int C) {
        ArrayList<Integer> previous = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int ans = 0;

        previous.add(1);
        previous.add(1);

        for (int i = 1; i < A; i++) {
            int currentArrayListSize = previous.size();
            System.out.println("previous size = " + currentArrayListSize);
            current.clear();
            current.add(1);
            // System.out.println("before entring nested loop");
            // System.out.println(previous);
            for (int j = 1; j < currentArrayListSize; j++) {
                // System.out.println(j);
                int diagonal = previous.get(j - 1) % C;
                // System.out.println("diagonal = " + diagonal);
                int top = previous.get(j) % C;
                // System.out.println("top = " + top);
                // System.out.println("sum = " + top + diagonal);
                current.add((diagonal + top));
            }
            current.add(1);
            previous.clear();
            // System.out.println(current);
            previous = new ArrayList<>(current);
            // System.out.println("After assigning");
            // System.out.println(previous);
        }

        ans = current.get(B);
        return ans % C;
    }

    public static int solve2D(int a, int b, int c) {
        int[][] tri = new int[a][a + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++)
                tri[i][j] = 0;
        }

        for (int i = 1; i <= a; i++) {
            tri[i][0] = 1;
            tri[i][i] = 1;
            for (int j = 1; j <= b; j++) {
                tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];
                // System.out.println(tri[i][j] + " ");
            }
            // System.out.println(" ");
        }

        return tri[a][b] % c;
    }
}