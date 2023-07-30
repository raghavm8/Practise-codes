package AdvancedDSA.Backtracking;

import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;

public class UniquePermuation {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        // ArrayList<ArrayList<Integer>> ans = permute(arr);
        // for (int i = 0; i < ans.size(); i++) {
        // for (Integer arrayList : ans.get(i)) {
        // System.out.print(arrayList + " ");
        // }
        // System.out.println();
        // }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = A.size();
        ArrayList<Integer> frequency = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            frequency.add(0);
        }

        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            int freq = frequency.get(num);
            frequency.set(num, ++freq);
        }

        getPermutations(frequency, A, 0, ans, n, temp);
        return ans;
    }

    private void getPermutations(ArrayList<Integer> frequency, ArrayList<Integer> a, int index,
            ArrayList<ArrayList<Integer>> ans, int n, ArrayList<Integer> temp) {

        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < frequency.size(); i++) {
            int freq = frequency.get(i);
            if (freq > 0) {
                freq--;
                frequency.set(i, freq);
                temp.add(index, i);

                getPermutations(frequency, a, index + 1, ans, n, temp);

                temp.remove(index);
                freq++;
                frequency.set(i, freq);
            }
        }
    }
}