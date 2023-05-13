package Strings;

public class CheckAnagrams {
    public static void main(String[] args) {

    }

    public int solve(String A, String B) {
        int Alength = A.length();
        int Blength = B.length();

        if (Alength != Blength)
            return 0;

        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < Alength; i++) {
            a[i] = 0;
            b[i] = 0;
        }

        for (int i = 0; i < Alength; i++) {
            char ac = A.charAt(i);
            char bc = B.charAt(i);
            a[ac - 'a'] += 1;
            b[bc - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return 0;
        }
        return 1;
    }
}
