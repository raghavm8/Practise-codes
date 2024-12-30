package Maths;

public class ModArray {
    public int solve(int[] A, int B) {
        int n = A.length;
        long x = 1;
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            long remainder = (A[i] % B * x % B) % B;
            x = (x * 10) % B;
            ans = (ans + remainder) % B;
        }
        return (int) ans;
    }
}
