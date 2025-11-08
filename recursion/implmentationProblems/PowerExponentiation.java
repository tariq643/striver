package dsa.striver.recursion.implmentationProblems;

public class PowerExponentiation {

    public double myPow(double x, int n) {
        //your code goes here

        if (n < 0) {
            n = -1 * n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        PowerExponentiation powerExponentiation = new PowerExponentiation();
        System.out.println(powerExponentiation.myPow(3,5));
    }
}
