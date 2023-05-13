package AdvancedDSA.Maths;

public class CountOfGcd {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int[] factors = new int[n];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
        }

        int[] spf = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i < max + 1; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < max + 1; j = j + i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int f = getFactor(A[i], spf);
            factors[i] = f;
        }
        return factors;
    }

    public static int getFactor(int n, int[] spf) {
        int ans = 1;
        int pf = spf[n];
        while (pf > 1) {
            int count = 0;
            while (n % pf == 0) {
                count++;
                n = n / pf;
            }
            ans = ans * (count + 1);
            pf = spf[n];
        }
        return ans;
    }

}