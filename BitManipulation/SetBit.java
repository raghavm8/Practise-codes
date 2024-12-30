package BitManipulation;

public class SetBit {
    public int solve(int A, int B) {
        int num = 1 << A;
        if (A == B)
            return num;

        num = num + (1 << B);
        return num;
    }
}
