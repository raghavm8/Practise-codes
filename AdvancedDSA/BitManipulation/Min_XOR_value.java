package AdvancedDSA.BitManipulation;

import java.util.Arrays;

public class Min_XOR_value {
    public static void main(String[] args) {

    }

    public int findMinXor(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, A[i] ^ A[i + 1]);
        }

        return ans;
    }
}


// 001: 5 + 
// 010: 8*2 
// 011: 9 + 9*2
// 100: 8*4
// 101: 5*4+1*4
// -------------
// 2*4+2*2+3
// 8 +4+3

// 24+32+27+16+5