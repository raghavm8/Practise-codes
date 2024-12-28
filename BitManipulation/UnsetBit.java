package BitManipulation;

public class UnsetBit {
    public int solve(int A, int B) {
        return ((A >> B) & 1) == 1 ? (A ^ (1 << B)) : A;
    }
}
