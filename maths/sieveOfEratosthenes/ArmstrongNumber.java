package dsa.striver.maths.sieveOfEratosthenes;

public class ArmstrongNumber {

    public boolean isArmstrong(int n) {

        if (n >= 1 && n <= 9) {
            return true;
        }

        int sum = 0, dummy = n;
        while (dummy > 0) {
            int temp = dummy % 10;
            sum = sum + (temp * temp * temp);
            dummy = dummy / 10;
        }
        return n == sum;
    }

    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        System.out.println(armstrongNumber.isArmstrong(3));
    }
}
