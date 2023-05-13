package Strings;

public class CountOccurences {
    public static void main(String[] args) {

    }

    public int solve(String A) {
        int n = A.length();
        // String bob = "bob";
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            if (A.charAt(i) == 'o') {
                if (A.charAt(i-1) == 'b' && A.charAt(i+1) == 'b')
                    count++;     
            }
        }

        return count;
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {

        // if(i+1>bob.length()){

        // }
        // }

    }
}