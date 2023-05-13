package AdvancedDSA.Maths;

public class DeleteOne {
    public static void main(String[] args) {
        int[] a = new int[] { 21, 7, 3, 42, 63 };
        System.out.println(solve(a));
    }

    public static int solve(int[] A) {
        int n = A.length;
        int ans = -1;
        int[] prefixGCD = new int[n];
        int[] suffixGCD = new int[n];

        prefixGCD[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(Math.max(prefixGCD[i - 1], A[i]), Math.min(prefixGCD[i - 1], A[i]));
        }

        suffixGCD[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(Math.max(suffixGCD[i + 1], A[i]), Math.min(suffixGCD[i + 1], A[i]));
        }

        ans = suffixGCD[1];
        for (int i = 1; i < n - 1; i++) {
            int gcdValue = gcd(Math.max(prefixGCD[i - 1], suffixGCD[i + 1]),
                    Math.min(prefixGCD[i - 1], suffixGCD[i + 1]));
            ans = Math.max(ans, gcdValue);
        }
        ans = Math.max(ans, prefixGCD[n - 2]);

        return ans;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
