package AdvancedDSA.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubSets {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        ArrayList<ArrayList<Integer>> ans = subsets(A);
        for (int i = 0; i < ans.size(); i++) {
            for (Integer arrayList : ans.get(i)) {
                System.out.print(arrayList + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        Collections.sort(A);
        getSubSets(A, ans, temp, 0);
        return ans;
    }

    private static void getSubSets(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp,
            int index) {
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < a.size(); i++) {
            temp.add(a.get(i));
            getSubSets(a, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}