package InterviewQuestions;

public class MajorityElement {
    public static int solve(int[] a) {
        int n = a.length;
        int ans = 0;
        int freq = 0;

        for (int i = 0; i < n; i++) {
            if (freq == 0) {
                ans = a[i];
                freq++;
            } else {
                if (a[i] == ans)
                    freq++;
                else
                    freq--;
            }
        }

        if (freq == 0)
            return -1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ans)
                count++;
        }

        return count > n / 2 ? ans : -1;
    }

    public static void main(String[] args) {
        int[] a = { 2, 1, 2 };
        // System.out.println(solve(a));
    }
}
