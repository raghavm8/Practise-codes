package Maths;

public class DivisibilityBy3 {
    public int solve(int[] A) {
        int n = A.length;
        long ans = 0;
        int x = 1;
        long num = 0;

        for (int i = 0; i < n; i++) {
            long remainder = (x % 3 * A[i] % 3) % 3;
            x = (x * 10) % 3;
            ans = (ans % 3 + remainder % 3) % 3;

        }
        return ans == 0 ? 1 : 0;
    }
}
