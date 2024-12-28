package BitManipulation;

public class CheckBit {
    public int solve(int A, int B) {
        return (A >> B) & 1;
    }
}
