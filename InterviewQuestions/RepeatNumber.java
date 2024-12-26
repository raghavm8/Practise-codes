package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class RepeatNumber {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList();
        a.add(2);
        a.add(2);
        a.add(3);

        System.out.println(repeatedNumber(a));
    }

    public static int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int num1 = 0, count1 = 0;
        int num2 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            int num = a.get(i);

            if (num1 == num) {
                count1++;
                continue;
            } else if (num2 == num) {
                count2++;
                continue;
            } else if (count1 == 0) {
                num1 = num;
                count1++;
                continue;
            } else if (count2 == 0 && num != num1) {
                num2 = num;
                count2++;
                continue;
            } else if (num != num1 && num != num2) {
                count1--;
                count2--;
                if (count1 == 0)
                    num1 = 0;
                if (count2 == 0)
                    num2 = 0;
            }
        }

        // System.out.println("num1 = " + count1);
        // System.out.println("num2 = " + count2);

        if (count1 == 0 && count2 == 0)
            return -1;

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) == num1)
                count1++;
            else if (a.get(i) == num2)
                count2++;
        }

        // System.out.println("num1 = " + count1);
        // System.out.println("num2 = " + count2);
        // System.out.println("n" + n);

        return count1 > n / 3 ? num1 : count2 > n / 3 ? num2 : -1;
    }
}

// 59 1000727 1000727 1000641 1000517 1000212 1000532 1000727 1001000 1000254
// 1000106 1000405
// 1000100 1000736 1000727 1000727 1000787 1000105 1000713 1000727 1000333
// 1000069 1000727 1000877 1000222 1000727
// 1000505 1000641 1000533 1000727 1000727 1000727 1000508 1000475 1000727
// 1000573 1000727 1000618 1000727 1000309
// 1000486 1000792 1000727 1000727 1000426 1000547 1000727 1000972 1000575
// 1000303 1000727 1000533 1000669 1000489
// 1000727 1000329 1000727 1000050 1000209 1000109
