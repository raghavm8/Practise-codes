package AdvancedDSA.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] A) {
        int n = A.length;
        int left = 0, right = n - 1;
        int ans = -1;
        while (left < right) {
            int distance = right - left;
            int minWall = Math.min(A[left], A[right]);
            ans = Math.max(distance * minWall, ans);
            if (A[left] < A[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}
