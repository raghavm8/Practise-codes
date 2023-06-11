package AdvancedDSA.Maths;

import java.util.ArrayList;

public class RangePrime {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] isPrime = new boolean[B + 1];
        for (int i = 0; i < B + 1; i++) {
            isPrime[i] = false;
        }

        for (int i = 2; i < B + 1; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= B; j += 2) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = A; i <= B; i++) {
            if (isPrime[i]) {
                arr.add(i);
            }
        }

        return arr;
    }

}
