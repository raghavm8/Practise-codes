package AdvancedDSA.Backtracking;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[A.size()];
        ArrayList<Integer> temp = new ArrayList<>();

        getPermutations(A, visited, ans, temp, 0);
        return ans;
    }

    private void getPermutations(ArrayList<Integer> a, boolean[] visited, ArrayList<ArrayList<Integer>> answerList,
            ArrayList<Integer> temp, int index) {
        if (index == a.size()) {
            answerList.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < a.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(index, a.get(i));
                getPermutations(a, visited, answerList, temp, index + 1);
                temp.remove(index);
                visited[i] = false;
            }
        }
    }
}
