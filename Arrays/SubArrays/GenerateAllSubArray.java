package Arrays.SubArrays;

import java.util.ArrayList;

public class GenerateAllSubArray {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 3, 4 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        // System.out.println(solve(a));
        print(a);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = i; j < A.size(); j++) {
                a.add(A.get(j));
                ans.add(new ArrayList<>(a));
            }
        }

        return ans;
    }

    public static void print(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // { 1, 2, 3, 4 };
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                System.out.println(A.get(j));
            }
            System.out.println();
        }
    }
}