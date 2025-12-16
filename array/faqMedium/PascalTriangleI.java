package dsa.striver.array.faqMedium;

public class PascalTriangleI {

    public int pascalTriangleI(int r, int c) {
        return nCrMinimalTime(r - 1,c - 1);
    }

    private int nCrMinimalTime (int n, int r) {

        if (r > n - r) {
            r = n - r;
        }
        if (n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }
}
