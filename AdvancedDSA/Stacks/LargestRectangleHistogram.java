package AdvancedDSA.Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int ans = Integer.MIN_VALUE;
        int[] ns_left = nearestSmallestLeft(A);
        int[] ns_right = nearestSmallestRight(A);

        int n = A.size();
        for (int i = 0; i < n; i++) {
            int tempValue = ns_right[i] - ns_left[i] - 1;
            int area = A.get(i) * tempValue;

            ans = Math.max(area, ans);
        }

        return ans;
    }

    public static int[] nearestSmallestRight(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arrayList.get(i) <= arrayList.get(stack.peek()))
                stack.pop();

            if (stack.isEmpty())
                arr[i] = n;
            else
                arr[i] = arrayList.get(stack.peek());
            stack.push(arrayList.get(i));
        }
        return arr;
    }

    public static int[] nearestSmallestLeft(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arrayList.get(i) <= arrayList.get(stack.peek()))
                stack.pop();

            if (stack.isEmpty())
                arr[i] = -1;
            else
                arr[i] = arrayList.get(stack.peek());
            stack.push(arrayList.get(i));
        }
        return arr;
    }
}
