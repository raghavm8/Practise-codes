package AdvancedDSA.Stacks;

import java.util.Stack;
import java.util.Arrays;

import AdvancedDSA.Sorting.SumTheDifference;

public class MaxMin {
    public static void main(String[] args) {

    }

    public static int[] getNearestGreaterToRight(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                ans[i] = n;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] getNearestGreaterToLeft(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] getNearestSmallerToRight(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                ans[i] = n;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] getNearestSmallerToLeft(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public int solve(int[] A) {
        int n = A.length;
        int[] ng_left = getNearestGreaterToLeft(A);
        int[] ng_right = getNearestGreaterToRight(A);
        int[] ns_left = getNearestSmallerToLeft(A);
        int[] ns_right = getNearestSmallerToRight(A);
        long ans = 0;
        int mod = 1000000007;

        long totalMax = 0;
        long totalMin = 0;
        for (int i = 0; i < n; i++) {
            long numberOfTimesMax = (1l * (i - ng_left[i]) * (ng_right[i] - i)) % mod;
            long numberOfTimesMin = (1l * (i - ns_left[i]) * (ns_right[i] - i)) % mod;

            totalMax = (totalMax + (numberOfTimesMax * A[i]) % mod) % mod;
            totalMin = (totalMin + (numberOfTimesMin * A[i]) % mod) % mod;
        }

        ans = totalMax - totalMin;
        return ((int) ans + mod) % mod;
    }
}

// class Solution {
// // leftsmaller
// public int[] firstsmallertoleft(int[] A, int[] Arr) {
// Arrays.fill(Arr, -1);
// Stack<Integer> s = new Stack<>();
// for (int i = 0; i < A.length; i++) {
// while (s.size() != 0 && A[s.peek()] >= A[i])
// s.pop();
// if (s.size() != 0)
// Arr[i] = s.peek();
// s.push(i);
// }
// return Arr;
// }

// // right smaller
// public int[] firstsmallertoright(int[] A, int[] Arr) {
// Arrays.fill(Arr, A.length);
// Stack<Integer> s = new Stack<>();
// for (int i = A.length - 1; i >= 0; i--) {
// while (s.size() != 0 && A[s.peek()] >= A[i])
// s.pop();
// if (s.size() != 0)
// Arr[i] = s.peek();
// s.push(i);
// }
// return Arr;
// }

// public int solve(int[] A) {
// int[] Ls = new int[A.length];
// int[] Rs = new int[A.length];
// int[] LG = new int[A.length];
// int[] RG = new int[A.length];
// firstsmallertoleft(A, Ls);
// firstsmallertoright(A, Rs);
// firstlargertoleft(A, LG);
// firstlargertoright(A, RG);
// // for(int i=0;i<A.length;i++)
// // System.out.print(Rs[i]+" ");
// long max = 0;
// long min = 0;
// for (int i = 0; i < A.length; i++) {
// min += (long) A[i] * ((long) (i - Ls[i]) * (long) (Rs[i] - i));
// max += (long) A[i] * ((long) (i - LG[i]) * (long) (RG[i] - i));

// }
// return (int) ((max - min) % 1000000007);

// }

// // first larger to right
// public int[] firstlargertoright(int[] A, int[] Arr) {
// Arrays.fill(Arr, A.length);
// Stack<Integer> s = new Stack<>();
// for (int i = A.length - 1; i >= 0; i--) {
// while (s.size() != 0 && A[s.peek()] <= A[i])
// s.pop();
// if (s.size() != 0)
// Arr[i] = s.peek();
// s.push(i);
// }
// return Arr;
// }

// // firstlargertoleft
// public int[] firstlargertoleft(int[] A, int[] Arr) {
// Arrays.fill(Arr, -1);
// Stack<Integer> s = new Stack<>();
// for (int i = 0; i < A.length; i++) {
// while (s.size() != 0 && A[s.peek()] <= A[i])
// s.pop();
// if (s.size() != 0)
// Arr[i] = s.peek();
// s.push(i);
// }
// return Arr;
// }

// }
