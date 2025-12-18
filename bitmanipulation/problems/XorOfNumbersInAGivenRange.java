package dsa.striver.bitmanipulation.problems;

public class XorOfNumbersInAGivenRange {

    private int xorOfNumbersTillN (int n) {

        if (n % 4 == 0) {
            return n;
        }
        if (n % 4 == 1) {
            return 1;
        }
        if (n % 4 == 2) {
            return n + 1;
        }
        return 0;
    }

    public int findRangeXOR(int l, int r) {
        //your code goes here
        return this.xorOfNumbersTillN(l - 1) ^ this.xorOfNumbersTillN(r);
    }
}
