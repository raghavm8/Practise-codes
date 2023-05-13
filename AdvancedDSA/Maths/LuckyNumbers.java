package AdvancedDSA.Maths;

public class LuckyNumbers {
    public static void main(String[] args) {

    }

    public int solve(int A) {
        int ans = 0;
        int[] spf = new int[A + 1];

        for (int i = 0; i <= A; i++)
            spf[i] = i;

        for (int i = 2; i <= A; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= A; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

        for (int i = 2; i < A; i++) {
            if (spf[i] != i)
                ans += getFactors(i, spf) ? 1 : 0;
        }

        return ans;
    }

    public static boolean getFactors(int n, int[] spf) {
        int pf = spf[n];
        int count = 0;
        while (n > 0) {
            while (n % pf == 0) {
                n /= pf;
            }
            count++;
            pf = spf[n];
        }

        return count == 2 ? true : false;
    }
}
