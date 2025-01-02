package Sorting;

public class ColorSorting {
    public class Solution {
        public int[] sortColors(int[] A) {
            int n = A.length;
            int r = 0, w = 0, b = 0;

            for (int i = 0; i < n; i++) {
                if (A[i] == 0)
                    r++;
                else if (A[i] == 1)
                    w++;
                else if (A[i] == 2)
                    b++;
            }

            int i = 0;
            while (r >= 0 || b >= 0 || w >= 0) {
                if (i == n)
                    break;
                if (r > 0) {
                    A[i++] = 0;
                    r--;
                } else if (w > 0) {
                    A[i++] = 1;
                    w--;
                } else if (b > 0) {
                    A[i++] = 2;
                    b--;
                }

            }
            return A;
        }
    }

}
