package AdvancedDSA.Maths;

import java.util.ArrayList;

public class PrimeSum {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isPrime = new boolean[A];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < A; i++)
            isPrime[i] = true;
        for (int i = 2; i * i < A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < A; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                ans.add(i);
                ans.add(A - 1);
            }
        }
        return ans;
    }
}
