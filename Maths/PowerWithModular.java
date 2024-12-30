package Maths;

public class PowerWithModular {
    public int solve(int A, int B, int C) {
        long num = 1;

        for (int i = 0; i < B; i++) {
            num = (num % C * A % C) % C;
        }

        return (int) num;
    }
}
