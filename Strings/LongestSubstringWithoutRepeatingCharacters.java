package Strings;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("answer = " + lengthOfLongestSubstring("aabaab!bb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        if(n==0)
            return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (hm.containsKey(currentChar)) {
                // int j=0;
                while (true) {
                    if (s.charAt(start) == currentChar) {
                         hm.remove(s.charAt(start));
                         start++;
                        break;
                    }
                    hm.remove(s.charAt(start));
                    start++;
                }
                hm.put(currentChar, 1);
            } else {
                hm.put(currentChar, 1);
            }
            ans = Math.max(hm.size(), ans);
        }
        System.out.println(hm);
        return ans;
    }
}