package AdvancedDSA.Maths;

public class PrimeModuloInverse {
    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        int ans = 0;
        int power = B - 2;
        ans = getPoweredNUmber(A, B, power);
        return ans;
    }

    public static int getPoweredNUmber(int a, int b, int mod) {
        if (b == 0)
            return 1;

        int x = getPoweredNUmber(a, b / 2, mod);

        if (b % 2 == 0) {
            return (x * x) % mod;
        } else {
            int y = (x * x) % mod;
            return (a * y) % mod;
        }
    }
}