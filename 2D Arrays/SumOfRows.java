import java.util.ArrayList;

public class SumOfRows {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int rows = A.size();
        int cols = A.get(0).size();

        for (ArrayList<Integer> i : A) {
            int sum = 0;
            for (Integer j : i) {
                sum += j;
            }
            ans.add(sum);
        }
        return ans;
    }
}
