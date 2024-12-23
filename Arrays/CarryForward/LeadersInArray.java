package Arrays.CarryForward;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        // int[] a = {16, 17, 4, 3, 5, 2};
        // System.out.println(solve(a));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = a.size();
        int max = Integer.MIN_VALUE;
        
        for (int i = n - 1; i > 0; i--) {
            int num = a.get(i);
            if (num > max) {
                ans.add(num);
                max = num;
            }
        }
        return ans;
    }
}
