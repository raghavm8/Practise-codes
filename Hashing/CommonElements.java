package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElements {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int an = A.length;

        for (int i = 0; i < an; i++) {
            if (hm.containsKey(A[i])) {
                int value = hm.get(A[i]);
                value++;
                hm.remove(A[i]);
                hm.put(A[i], value);
            } else
                hm.put(A[i], 1);
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (Integer num : B) {
            if (hm.containsKey(num)) {
                a.add(num);
                int value = hm.get(num);
                value--;
                hm.remove(num);
                if (value > 0)
                    hm.put(num, value);
            }
        }

        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ans[i] = a.get(i);
        }
        return ans;
    }
}
