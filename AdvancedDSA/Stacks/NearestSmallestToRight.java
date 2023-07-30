package AdvancedDSA.Stacks;

import java.util.Stack;

public class NearestSmallestToRight {
    public int[] prevGreater(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (stack.isEmpty() == false && A[i] <= A[stack.peek()])
                stack.pop();

            if (stack.isEmpty() == false)
                ans[i] = A[stack.peek()];
            else
                ans[i] = -1;
            stack.push(A[i]);
        }
        return ans;
    }
}
