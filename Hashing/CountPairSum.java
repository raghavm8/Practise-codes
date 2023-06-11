import java.util.HashMap;

public class CountPairSum {
    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        int count = 0;
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(A[i])) {
                int value = hm.get(A[i]);
                value++;
                hm.remove(A[i]);
                hm.put(A[i], value);
            } else
                hm.put(A[i], 1);
        }

        for (int i = 0; i < n; i++) {
            
        }

        return count%1000000007;
    }
}   