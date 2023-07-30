package AdvancedDSA.Maths;

public class VeryLargePower {
    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        int mod = 1000000007;
        long fact = 1;

        for (int i = 2; i <= B; i++) {
            fact = (fact * i) % (mod - 1);
        }

        return getAns(A, fact, mod);
    }

    public static int getAns(long a, long fact, int mod) {
        long ans = 1;

        while (fact > 0) {
            if ((fact & 1) == 1) {
                ans = (ans % mod * a % mod) % mod;
            }
            a = (a % mod * a % mod) % mod;
            fact >>= 1;
        }

        return (int) ans % mod;
    }
}
