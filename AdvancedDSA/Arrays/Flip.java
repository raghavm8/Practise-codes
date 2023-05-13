package AdvancedDSA.Arrays;

import java.util.ArrayList;

public class Flip {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> flip(String A) {
        int n = A.length();
        int maxCount = Integer.MIN_VALUE;
        int currCount = 0;
        int left = -1, leftAnswer = 0;
        int right = -1, rightAnswer = 0;

        for (int i = 0; i < n; i++) {
            char currChar = A.charAt(i);
            if (currChar == '0')
                currCount++;
            else
                currCount--;

            if (currCount >= 0) {
                if (currCount == 1 && left < 0) {
                    left = i;
                }
                right = i;
            }

            if (currCount > maxCount) {
                maxCount = currCount;
                leftAnswer = left;
                rightAnswer = right;
            }

            if (currCount < 0) {
                currChar = 0;
                left = -1;
                right = -1;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (leftAnswer != -1) {
            ans.add(leftAnswer + 1);
            ans.add(rightAnswer + 1);
        }
        return ans;
    }
}

