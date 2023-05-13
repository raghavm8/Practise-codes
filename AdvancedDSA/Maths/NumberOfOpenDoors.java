package AdvancedDSA.Maths;

public class NumberOfOpenDoors {
    public static void main(String[] args) {

    }

    public int solve(int A) {
        boolean[] arr = new boolean[A + 1];
        int ans = 0;
        for (int i = 0; i <= A; i++)
            arr[i] = false; // closed initially

        for (int i = 1; i <= A; i++) {
            for (int j = i; j <= A; j += i) {
                arr[j] = !arr[j];
                if (arr[j])
                    ans++;
                else
                    ans--;
            }
        }

        // for (int i = 0; i <= A; i++) {
        // if (arr[i])
        // ans++;
        // }
        return ans;
    }
}
