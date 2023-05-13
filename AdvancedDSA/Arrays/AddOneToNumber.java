package AdvancedDSA.Arrays;

import java.util.ArrayList;

public class AddOneToNumber {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        System.out.println(plusOne(arr));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        int i = n - 1;
        int carry = 1;
        while (i >= 0) {
            if (carry == 0)
                break;
            int num = A.get(i);
            A.set(i, num + carry);
            carry = 0;
            if (A.get(i) == 10) {
                A.set(i, 0);
                carry = 1;
            } else
                break;
            i--;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        if (carry == 1) {
            arr.add(1);
            for (int j = 0; j < n; j++) {
                arr.add(A.get(j));
            }
        } else if (A.get(0) == 0) {
            int k = 0;
            while (k < n && A.get(k) == 0) {
                k++;
            }

            for (int l = k; l < A.size(); l++) {
                arr.add(A.get(l));
            }
        }
        return arr;
    }
}